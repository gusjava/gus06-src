package gus06.entity.gus.file.rar.innosystec.unrar;

public class Inno_CommentHeader extends Inno_BaseBlock {
	
	public static final short commentHeaderSize = 6;
	
	private short unpSize;
	private byte unpVersion;
	private byte unpMethod;
	private short commCRC;
	
	public Inno_CommentHeader(Inno_BaseBlock bb, byte[] commentHeader)
	{
		super(bb);
		
		int pos =0;
		unpSize = Inno_Raw.readShortLittleEndian(commentHeader, pos);
		pos += 2;
		unpVersion |= commentHeader[pos]&0xff;
		pos++;
		
		unpMethod |= commentHeader[pos]&0xff;
		pos++;
		commCRC =Inno_Raw.readShortLittleEndian(commentHeader, pos);
	}
	
	public short getCommCRC()	{return commCRC;}
	public byte getUnpMethod()	{return unpMethod;}
	public short getUnpSize()	{return unpSize;}
	public byte getUnpVersion()	{return unpVersion;}
}