package gus06.entity.gus.file.rar.innosystec.unrar;

public class Inno_FileNameDecoder {
	public static int getChar(byte [] name,int pos){ 
		return name[pos]&0xff; 
	} 

	public static String decode(byte [] name,int encPos){ 
		int decPos = 0; 
		int flags = 0; 
		int flagBits = 0; 

		int low = 0; 
		int high = 0; 
		int highByte = getChar(name,encPos++); 
		StringBuffer buf = new StringBuffer(); 
		while(encPos < name.length){ 
			if(flagBits == 0){ 
				flags = getChar(name,encPos++); 
				flagBits = 8; 
			} 
			switch(flags >> 6){ 
			case 0: 
				buf.append((char)(getChar(name,encPos++))); 
				++decPos; 
				break; 
			case 1: 
				buf.append((char)(getChar(name,encPos++)+(highByte<<8))); 
				++decPos; 
				break; 
			case 2: 
				low = getChar(name,encPos); 
				high = getChar(name,encPos+1); 
				buf.append((char)((high << 8) + low)); 
				++decPos; 
				encPos += 2; 
				break; 
			case 3: 
				int length = getChar(name,encPos++); 
				if((length&0x80)!=0){ 
					int correction = getChar(name,encPos++); 
					for(length=(length&0x7f)+2;length>0&&decPos<name.length;length--,decPos++){ 
						low = (getChar(name,decPos) + correction)&0xff; 
						buf.append((char)((highByte << 8) + low)); 
					} 
				}else{ 
					for(length+=2;length>0&&decPos<name.length;length--,decPos++){ 
						buf.append((char)(getChar(name,decPos))); 
					} 
				} 
				break; 
			} 
			flags = (flags << 2) & 0xff; 
			flagBits -= 2; 
		} 
		return buf.toString(); 
	} 
}