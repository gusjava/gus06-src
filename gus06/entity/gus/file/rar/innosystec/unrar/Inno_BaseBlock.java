package gus06.entity.gus.file.rar.innosystec.unrar;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Inno_BaseBlock{
	
	Log logger = LogFactory.getLog(Inno_BaseBlock.class.getName());
	
	public static final short BaseBlockSize = 7;
	
	public static final short MHD_VOLUME = 0x0001;
	public static final short MHD_COMMENT = 0x0002;
	public static final short MHD_LOCK = 0x0004;
	public static final short MHD_SOLID = 0x0008;
	public static final short MHD_PACK_COMMENT = 0x0010;
	public static final short MHD_NEWNUMBERING = 0x0010;
	public static final short MHD_AV = 0x0020;
	public static final short MHD_PROTECT = 0x0040;
	public static final short MHD_PASSWORD = 0x0080;
	public static final short MHD_FIRSTVOLUME = 0x0100;
	public static final short MHD_ENCRYPTVER = 0x0200;
	
	
	public static final short LHD_SPLIT_BEFORE =  0x0001;
	public static final short LHD_SPLIT_AFTER  =  0x0002;
	public static final short LHD_PASSWORD     =  0x0004;
	public static final short LHD_COMMENT      =  0x0008;
	public static final short LHD_SOLID        =  0x0010;

	public static final short LHD_WINDOWMASK   =  0x00e0;
	public static final short LHD_WINDOW64     =  0x0000;
	public static final short LHD_WINDOW128    =  0x0020;
	public static final short LHD_WINDOW256    =  0x0040;
	public static final short LHD_WINDOW512    =  0x0060;
	public static final short LHD_WINDOW1024   =  0x0080;
	public static final short LHD_WINDOW2048   =  0x00a0;
	public static final short LHD_WINDOW4096   =  0x00c0;
	public static final short LHD_DIRECTORY    =  0x00e0;

	public static final short LHD_LARGE        =  0x0100;
	public static final short LHD_UNICODE      =  0x0200;
	public static final short LHD_SALT         =  0x0400;
	public static final short LHD_VERSION      =  0x0800;
	public static final short LHD_EXTTIME      =  0x1000;
	public static final short LHD_EXTFLAGS     =  0x2000;

	public static final short SKIP_IF_UNKNOWN  =  0x4000;
	public static final short LONG_BLOCK 	   = -0x8000;

	public static final short EARC_NEXT_VOLUME =  0x0001;
	public static final short EARC_DATACRC     =  0x0002;
	public static final short EARC_REVSPACE    =  0x0004;
	public static final short EARC_VOLNUMBER   =  0x0008;
	
	
	protected long positionInFile;
	
	protected short headCRC = 0;
	protected byte headerType = 0;
	protected short flags = 0;
	protected short headerSize = 0 ;

	public Inno_BaseBlock(){}
	
	public Inno_BaseBlock(Inno_BaseBlock bb)
	{
		this.flags = bb.getFlags();
    		this.headCRC = bb.getHeadCRC();
    		this.headerType = bb.getHeaderType().getHeaderByte();
    		this.headerSize = bb.getHeaderSize();
    		this.positionInFile = bb.getPositionInFile();
	}
	
	public Inno_BaseBlock(byte[] baseBlockHeader)
	{
		int pos = 0;
		this.headCRC = Inno_Raw.readShortLittleEndian(baseBlockHeader, pos);
		pos+=2;
		this.headerType |= baseBlockHeader[pos]&0xff;
		pos++;
		this.flags = Inno_Raw.readShortLittleEndian(baseBlockHeader, pos);
		pos+=2;
		this.headerSize = Inno_Raw.readShortLittleEndian(baseBlockHeader, pos);
	}
	
	
	public boolean hasArchiveDataCRC(){return (this.flags & EARC_DATACRC)!=0;}
	
	public boolean hasVolumeNumber(){return (this.flags & EARC_VOLNUMBER)!=0;}
	
	public boolean hasEncryptVersion(){return (flags & MHD_ENCRYPTVER)!=0;}
	
	
	public boolean isSubBlock()
	{
		 if(Inno_UnrarHeadertype.SubHeader.equals(headerType)) return true;
		 if(Inno_UnrarHeadertype.NewSubHeader.equals(headerType) && (flags & LHD_SOLID)!=0) return true;
		 return false;
		
	}

	public long getPositionInFile() {return positionInFile;}

	public short getFlags() {return flags;}

	public short getHeadCRC() {return headCRC;}
	
	public short getHeaderSize() {return headerSize;}

	public Inno_UnrarHeadertype getHeaderType() {return Inno_UnrarHeadertype.findType(headerType);}
	
	public void setPositionInFile(long positionInFile) {this.positionInFile = positionInFile;}
	
	public void print()
	{
		StringBuilder str  =new StringBuilder();
		str.append("HeaderType: " + getHeaderType());
		str.append("\nHeadCRC: "+Integer.toHexString(getHeadCRC()));
		str.append("\nFlags: "+Integer.toHexString(getFlags()));
		str.append("\nHeaderSize: "+getHeaderSize());
		str.append("\nPosition in file: "+getPositionInFile());
		logger.info(str.toString());
	}
}