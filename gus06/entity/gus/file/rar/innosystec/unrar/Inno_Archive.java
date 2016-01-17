package gus06.entity.gus.file.rar.innosystec.unrar;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Inno_Archive implements Closeable {

	private static Logger logger = Logger.getLogger(Inno_Archive.class.getName());
	private File file;
	private Inno_IReadOnlyAccess rof;
	private final Inno_UnrarCallback unrarCallback;
	private final Inno_ComprDataIO dataIO;
	private final List<Inno_BaseBlock> headers = new ArrayList<Inno_BaseBlock>();
	private Inno_MarkHeader markHead = null;
	private Inno_MainHeader newMhd = null;
	private Inno_EndArcHeader endHeader = null;
	private Inno_Unpack unpack;


	private long arcDataCRC = 0xffffffff;
	private int currentHeaderIndex;
	private boolean encrypted = false;
	private int sfxSize = 0;
	private long totalPackedSize = 0L;
	private long totalPackedRead = 0L;


	public Inno_Archive(File file) throws Inno_RarException, IOException
	{this(file, null);}

	public Inno_Archive(File file, Inno_UnrarCallback unrarCallback) throws Inno_RarException, IOException
	{
		setFile(file);
		this.unrarCallback = unrarCallback;
		dataIO = new Inno_ComprDataIO(this);
	}

	public File getFile() {return file;}

	void setFile(File file) throws IOException
	{
		this.file = file;
		totalPackedSize = 0L;
		totalPackedRead = 0L;
		close();
		rof = new Inno_ReadOnlyAccessFile(file);
	
		try{readHeaders();}
		catch(Exception e)
		{
			logger.log(Level.WARNING,"exception in archive constructor maybe file is encrypted or currupt",e);
		}
		
		// Calculate size of packed data
		for (Inno_BaseBlock block : headers)
		{
			if(block.getHeaderType() == Inno_UnrarHeadertype.FileHeader)
			totalPackedSize += ((Inno_FileHeader) block).getFullPackSize();
		}
		
		if(unrarCallback != null)
		unrarCallback.volumeProgressChanged(totalPackedRead,totalPackedSize);
	}


	public void bytesReadRead(int count)
	{
		if(count>0)
		{
			totalPackedRead += count;
			if(unrarCallback != null) 
			unrarCallback.volumeProgressChanged(totalPackedRead,totalPackedSize);
		}
	}

	public Inno_IReadOnlyAccess getRof() {return rof;}

	public List<Inno_FileHeader> getFileHeaders()
	{
		List<Inno_FileHeader> list = new ArrayList<Inno_FileHeader>();
		for (Inno_BaseBlock block : headers)
		{
			if(block.getHeaderType().equals(Inno_UnrarHeadertype.FileHeader))
			list.add((Inno_FileHeader) block);
		}
		return list;
	}

	public Inno_FileHeader nextFileHeader()
	{
		int n = headers.size();
		while(currentHeaderIndex < n)
		{
			Inno_BaseBlock block = headers.get(currentHeaderIndex++);
			if(block.getHeaderType() == Inno_UnrarHeadertype.FileHeader)
			return (Inno_FileHeader) block;
		}
		return null;
	}

	public Inno_UnrarCallback getUnrarCallback()	{return unrarCallback;}

	public boolean isEncrypted()
	{
		if(newMhd != null) return newMhd.isEncrypted();
		throw new NullPointerException("mainheader is null");
	}

	private void readHeaders() throws IOException, Inno_RarException
	{
		markHead = null;
		newMhd = null;
		endHeader = null;
		headers.clear();
		currentHeaderIndex = 0;
		int toRead = 0;

		long fileLength = this.file.length();

		while(true)
		{
			int size = 0;
			long newpos = 0;
			byte[] baseBlockBuffer = new byte[Inno_BaseBlock.BaseBlockSize];

			long position = rof.getPosition();

			// Weird, but is trying to read beyond the end of the file
			if (position >= fileLength) break;
			
			// logger.info("\n--------reading header--------");
			size = rof.readFully(baseBlockBuffer, Inno_BaseBlock.BaseBlockSize);
			if (size == 0) break;
			
			Inno_BaseBlock block = new Inno_BaseBlock(baseBlockBuffer);

			block.setPositionInFile(position);

			switch (block.getHeaderType())
			{
				case MarkHeader:
				markHead = new Inno_MarkHeader(block);
				if (!markHead.isSignature())
					throw new Inno_RarException(Inno_RarException.RarExceptionType.badRarArchive);
				
				headers.add(markHead);
				// markHead.print();
				break;

				case MainHeader:
				int mainHeaderSize = 0;
				toRead = block.hasEncryptVersion() ? Inno_MainHeader.mainHeaderSizeWithEnc
				: Inno_MainHeader.mainHeaderSize;
				byte[] mainbuff = new byte[toRead];
				mainHeaderSize = rof.readFully(mainbuff, toRead);
				Inno_MainHeader mainhead = new Inno_MainHeader(block, mainbuff);
				headers.add(mainhead);
				this.newMhd = mainhead;
				if (newMhd.isEncrypted())
					throw new Inno_RarException(Inno_RarException.RarExceptionType.rarEncryptedException);
				// mainhead.print();
				break;

				case SignHeader:
				int signHeaderSize = 0;
				toRead = Inno_SignHeader.signHeaderSize;
				byte[] signBuff = new byte[toRead];
				signHeaderSize = rof.readFully(signBuff, toRead);
				Inno_SignHeader signHead = new Inno_SignHeader(block, signBuff);
				headers.add(signHead);
				// logger.info("HeaderType: SignHeader");

				break;

				case AvHeader:
				int avHeaderSize = 0;
				toRead = Inno_AVHeader.avHeaderSize;
				byte[] avBuff = new byte[toRead];
				avHeaderSize = rof.readFully(avBuff, toRead);
				Inno_AVHeader avHead = new Inno_AVHeader(block, avBuff);
				headers.add(avHead);
				// logger.info("headertype: AVHeader");
				break;

				case CommHeader:
				int commHeaderSize = 0;
				toRead = Inno_CommentHeader.commentHeaderSize;
				byte[] commBuff = new byte[toRead];
				commHeaderSize = rof.readFully(commBuff, toRead);
				Inno_CommentHeader commHead = new Inno_CommentHeader(block, commBuff);
				headers.add(commHead);
				// logger.info("method: "+commHead.getUnpMethod()+"; 0x"+
				// Integer.toHexString(commHead.getUnpMethod()));
				newpos = commHead.getPositionInFile()
				+ commHead.getHeaderSize();
				rof.setPosition(newpos);

				break;
				case EndArcHeader:

				toRead = 0;
				if (block.hasArchiveDataCRC())
				toRead += Inno_EndArcHeader.endArcArchiveDataCrcSize;
				
				if (block.hasVolumeNumber()) 
				toRead += Inno_EndArcHeader.endArcVolumeNumberSize;
				
				Inno_EndArcHeader endArcHead;
				if (toRead > 0)
				{
					int endArcHeaderSize = 0;
					byte[] endArchBuff = new byte[toRead];
					endArcHeaderSize = rof.readFully(endArchBuff, toRead);
					endArcHead = new Inno_EndArcHeader(block, endArchBuff);
					// logger.info("HeaderType: endarch\ndatacrc:"+
					// endArcHead.getArchiveDataCRC());
				}
				else
				{
					// logger.info("HeaderType: endarch - no Data");
					endArcHead = new Inno_EndArcHeader(block, null);
				}
				
				headers.add(endArcHead);
				this.endHeader = endArcHead;
				// logger.info("\n--------end header--------");
				return;

				default:
				byte[] blockHeaderBuffer = new byte[Inno_BlockHeader.blockHeaderSize];
				int bhsize = rof.readFully(blockHeaderBuffer,
				Inno_BlockHeader.blockHeaderSize);
				Inno_BlockHeader blockHead = new Inno_BlockHeader(block,
				blockHeaderBuffer);

				switch (blockHead.getHeaderType())
				{
					case NewSubHeader:
					case FileHeader:
					toRead = blockHead.getHeaderSize()
						- Inno_BlockHeader.BaseBlockSize
						- Inno_BlockHeader.blockHeaderSize;
					byte[] fileHeaderBuffer = new byte[toRead];
					int fhsize = rof.readFully(fileHeaderBuffer, toRead);

					Inno_FileHeader fh = new Inno_FileHeader(blockHead, fileHeaderBuffer);
					headers.add(fh);
					newpos = fh.getPositionInFile() + fh.getHeaderSize()
						+ fh.getFullPackSize();
					rof.setPosition(newpos);
					break;

					case ProtectHeader:
					toRead = blockHead.getHeaderSize()
						- Inno_BlockHeader.BaseBlockSize
						- Inno_BlockHeader.blockHeaderSize;
					byte[] protectHeaderBuffer = new byte[toRead];
					int phsize = rof.readFully(protectHeaderBuffer, toRead);
					Inno_ProtectHeader ph = new Inno_ProtectHeader(blockHead,
						protectHeaderBuffer);

					// logger.info("totalblocks"+ph.getTotalBlocks());
					newpos = ph.getPositionInFile() + ph.getHeaderSize();
					rof.setPosition(newpos);
					break;

					case SubHeader:
					{
						byte[] subHeadbuffer = new byte[Inno_SubBlockHeader.SubBlockHeaderSize];
						int subheadersize = rof.readFully(subHeadbuffer,
						Inno_SubBlockHeader.SubBlockHeaderSize);
						Inno_SubBlockHeader subHead = new Inno_SubBlockHeader(blockHead,
						subHeadbuffer);
						subHead.print();
					
						switch(subHead.getSubType())
						{
							case MAC_HEAD:
							{
								byte[] macHeaderbuffer = new byte[Inno_MacInfoHeader.MacInfoHeaderSize];
								int macheadersize = rof.readFully(macHeaderbuffer,
								Inno_MacInfoHeader.MacInfoHeaderSize);
								Inno_MacInfoHeader macHeader = new Inno_MacInfoHeader(subHead,
								macHeaderbuffer);
								macHeader.print();
								headers.add(macHeader);
								break;
							}
							// TODO implement other subheaders
							
							case BEEA_HEAD: break;
							
							case EA_HEAD:
							{
								byte[] eaHeaderBuffer = new byte[Inno_EAHeader.EAHeaderSize];
								int eaheadersize = rof.readFully(eaHeaderBuffer,
								Inno_EAHeader.EAHeaderSize);
								Inno_EAHeader eaHeader = new Inno_EAHeader(subHead,
								eaHeaderBuffer);
								eaHeader.print();
								headers.add(eaHeader);
								break;
							}
							case NTACL_HEAD: break;
							case STREAM_HEAD: break;
							case UO_HEAD:
							toRead = subHead.getHeaderSize();
							toRead -= Inno_BaseBlock.BaseBlockSize;
							toRead -= Inno_BlockHeader.blockHeaderSize;
							toRead -= Inno_SubBlockHeader.SubBlockHeaderSize;
							byte[] uoHeaderBuffer = new byte[toRead];
							int uoHeaderSize = rof
								.readFully(uoHeaderBuffer, toRead);
							Inno_UnixOwnersHeader uoHeader = new Inno_UnixOwnersHeader(
							subHead, uoHeaderBuffer);
							uoHeader.print();
							headers.add(uoHeader);
							break;
							
							default:break;
						}
						break;
					}
					
					default:
					logger.warning("Unknown Header");
					throw new Inno_RarException(Inno_RarException.RarExceptionType.notRarArchive);
				}
			}
		}
	}




	public void extractFile(Inno_FileHeader hd, OutputStream os) throws Inno_RarException
	{
		if(!headers.contains(hd)) 
		throw new Inno_RarException(Inno_RarException.RarExceptionType.headerNotInArchive);
	
	try{doExtractFile(hd, os);}
	catch (Exception e)
	{
		if (e instanceof Inno_RarException) {
		throw (Inno_RarException) e;
		} else {
		throw new Inno_RarException(e);
		}
	}
	}

	private void doExtractFile(Inno_FileHeader hd, OutputStream os) throws Inno_RarException, IOException
	{
	dataIO.init(os);
	dataIO.init(hd);
	dataIO.setUnpFileCRC(this.isOldFormat() ? 0 : 0xffFFffFF);
	if (unpack == null) {
		unpack = new Inno_Unpack(dataIO);
	}
	if (!hd.isSolid()) {
		unpack.init(null);
	}
	unpack.setDestSize(hd.getFullUnpackSize());
	try {
		unpack.doUnpack(hd.getUnpVersion(), hd.isSolid());
	
		// Verify file CRC
		hd = dataIO.getSubHeader();
		long actualCRC = hd.isSplitAfter() ? ~dataIO.getPackedCRC()
			: ~dataIO.getUnpFileCRC();
		int expectedCRC = hd.getFileCRC();
	
		if (actualCRC != expectedCRC) {
		//throw new Inno_RarException(Inno_RarException.RarExceptionType.crcError);
		}
	
		// if (!hd.isSplitAfter()) {
		// // Verify file CRC
		// if(~dataIO.getUnpFileCRC() != hd.getFileCRC()){
		// throw new RarException(RarExceptionType.crcError);
		// }
		// }
	} catch (Exception e) {
		unpack.cleanUp();
		if (e instanceof Inno_RarException) {
		// throw new RarException((RarException)e);
		throw (Inno_RarException) e;
		} else {
		throw new Inno_RarException(e);
		}
	}
	}

	public Inno_MainHeader getMainHeader()		{return newMhd;}
	public boolean isOldFormat()			{return markHead.isOldFormat();}

	public void close() throws IOException
	{
		if(rof != null)		{rof.close();rof = null;}
		if(unpack != null)	{unpack.cleanUp();}
	}
}