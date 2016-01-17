package gus06.entity.gus.file.rar.innosystec.unrar;

public class Inno_AVHeader extends Inno_BaseBlock {
	
	public static final int avHeaderSize = 7;
	
	private byte unpackVersion;
	private byte method;
	private byte avVersion;
	private int avInfoCRC;
	
	public Inno_AVHeader(Inno_BaseBlock bb, byte[] avHeader)
	{
		super(bb);
		int pos =0;
		unpackVersion |= avHeader[pos]&0xff;
		pos++;
		method |= avHeader[pos]&0xff;
		pos++;
		avVersion |= avHeader[pos]&0xff;
		pos++;
		avInfoCRC = Inno_Raw.readIntLittleEndian(avHeader, pos);
	}
	
	public int getAvInfoCRC() {return avInfoCRC;}
	public byte getAvVersion() {return avVersion;}
	public byte getMethod() {return method;}
	public byte getUnpackVersion() {return unpackVersion;}
}