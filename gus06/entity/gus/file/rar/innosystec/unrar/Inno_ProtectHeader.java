package gus06.entity.gus.file.rar.innosystec.unrar;

public class Inno_ProtectHeader extends Inno_BlockHeader {
	
	public static final int protectHeaderSize = 8;
	
	private byte version;
	private short recSectors;
	private int totalBlocks;
	private byte mark;
	
	
	public Inno_ProtectHeader(Inno_BlockHeader bh, byte[] protectHeader){
		super(bh);
		
		int pos = 0;
		version |= protectHeader[pos]&0xff;
		
		recSectors = Inno_Raw.readShortLittleEndian(protectHeader, pos);
		pos += 2;
		totalBlocks = Inno_Raw.readIntLittleEndian(protectHeader, pos);
		pos += 4;
		mark |= protectHeader[pos]&0xff;
	}
	
	
	public byte getMark() {
		return mark;
	}
	
	public short getRecSectors() {
		return recSectors;
	}
	
	public int getTotalBlocks() {
		return totalBlocks;
	}
	
	public byte getVersion() {
		return version;
	}
}