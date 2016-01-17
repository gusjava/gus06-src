package gus06.entity.gus.file.rar.innosystec.unrar;

public class Inno_SignHeader extends Inno_BaseBlock {
	
	public static final short signHeaderSize = 8;
	
	private int creationTime=0;
	private short arcNameSize=0;
	private short userNameSize=0;
	
	
	public Inno_SignHeader(Inno_BaseBlock bb, byte[] signHeader){
		super(bb);
		
		int pos = 0;
		creationTime = Inno_Raw.readIntLittleEndian(signHeader, pos);
		pos +=4;
		arcNameSize = Inno_Raw.readShortLittleEndian(signHeader, pos);
		pos+=2;
		userNameSize = Inno_Raw.readShortLittleEndian(signHeader, pos);
	}
	
	public short getArcNameSize() {
		return arcNameSize;
	}
	
	public int getCreationTime() {
		return creationTime;
	}
	
	public short getUserNameSize() {
		return userNameSize;
	}
}