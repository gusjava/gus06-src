package gus06.entity.gus.file.rar.innosystec.unrar;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Inno_MainHeader extends Inno_BaseBlock {
	private Log logger = LogFactory.getLog(Inno_MainHeader.class.getName());
	public static final short mainHeaderSizeWithEnc = 7;
	public static final short mainHeaderSize = 6;
	private short highPosAv;
	private int posAv;
	private byte encryptVersion;
	
	public Inno_MainHeader(Inno_BaseBlock bb, byte[] mainHeader) {
		super(bb);
		int pos = 0;
		highPosAv = Inno_Raw.readShortLittleEndian(mainHeader, pos);
		pos += 2;
		posAv = Inno_Raw.readIntLittleEndian(mainHeader, pos);
		pos+=4;
		
		if(hasEncryptVersion()){
			encryptVersion |= mainHeader[pos]&0xff;
		}
	}
	
	public boolean hasArchCmt(){
		return (this.flags & Inno_BaseBlock.MHD_COMMENT)!=0;
	}
	
	public byte getEncryptVersion() {
		return encryptVersion;
	}
	
	public short getHighPosAv() {
		return highPosAv;
	}
	
	public int getPosAv() {
		return posAv;
	}
	
	public boolean isEncrypted(){
		return (this.flags & Inno_BaseBlock.MHD_PASSWORD)!=0;
	}
	
	public boolean isMultiVolume(){
		return (this.flags & Inno_BaseBlock.MHD_VOLUME)!=0;
	}
	
	public boolean isFirstVolume(){
		return (this.flags & Inno_BaseBlock.MHD_FIRSTVOLUME)!=0;
	}
	
	public void print(){
		super.print();
		StringBuilder str=new StringBuilder();
		str.append("posav: "+getPosAv());
		str.append("\nhighposav: "+getHighPosAv());
		str.append("\nhasencversion: "+hasEncryptVersion()+(hasEncryptVersion()?getEncryptVersion():""));
		str.append("\nhasarchcmt: "+hasArchCmt());
		str.append("\nisEncrypted: "+isEncrypted());
		str.append("\nisMultivolume: "+isMultiVolume());
		str.append("\nisFirstvolume: "+isFirstVolume());
		str.append("\nisSolid: "+isSolid());
		str.append("\nisLocked: "+isLocked());
		str.append("\nisProtected: "+isProtected());
		str.append("\nisAV: "+isAV());
		logger.info(str.toString());
	}
	
	public boolean isSolid(){
		return (this.flags&MHD_SOLID)!=0;
	}
	
	public boolean isLocked(){
		return (this.flags&MHD_LOCK)!=0;
	}
	
	public boolean isProtected(){
		return (this.flags&MHD_PROTECT)!=0;
	}
	
	public boolean isAV(){
		return (this.flags&MHD_AV)!=0;
	}
	
	public boolean isNewNumbering(){
		return (this.flags&MHD_NEWNUMBERING)!=0;
	}
}