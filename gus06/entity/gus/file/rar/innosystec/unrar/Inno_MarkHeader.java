package gus06.entity.gus.file.rar.innosystec.unrar;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Inno_MarkHeader extends Inno_BaseBlock {
	
	private Log logger = LogFactory.getLog(Inno_MarkHeader.class.getName());
	private boolean oldFormat = false;
	
	public Inno_MarkHeader(Inno_BaseBlock bb){
		super(bb);
	}
	public boolean isValid(){
		if(!(getHeadCRC() == 0x6152)){
			return false;
		}
		if(!(getHeaderType() == Inno_UnrarHeadertype.MarkHeader)){
			return false;
		}
		if(!(getFlags() == 0x1a21)){
			return false;
		}
		if(!(getHeaderSize() == BaseBlockSize)){
			return false;
		}
		return true;
	}
	
	public boolean isSignature() {
        boolean valid=false;
        byte[] d = new byte[Inno_BaseBlock.BaseBlockSize];
        Inno_Raw.writeShortLittleEndian(d, 0, headCRC);
        d[2] = headerType;
        Inno_Raw.writeShortLittleEndian(d, 3, flags);
        Inno_Raw.writeShortLittleEndian(d, 5, headerSize);
        
        if (d[0] == 0x52) {
            if (d[1]==0x45 && d[2]==0x7e && d[3]==0x5e) {
                oldFormat=true;
                valid=true;
            }
            else if (d[1]==0x61 && d[2]==0x72 && d[3]==0x21 && d[4]==0x1a &&
                    d[5]==0x07 && d[6]==0x00) {
                oldFormat=false;
                valid=true;
            }
        }
        return valid;
    }

    public boolean isOldFormat() {
        return oldFormat;
    }
    
	public void print(){
		super.print();
		logger.info("valid: "+isValid());
	}
}