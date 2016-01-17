package gus06.entity.gus.file.rar.innosystec.unrar;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Inno_MacInfoHeader extends Inno_SubBlockHeader 
{
	private Log logger = LogFactory.getLog(getClass());
	
	public static final short MacInfoHeaderSize = 8;
	
	private int fileType;
	private int fileCreator;
	
	public Inno_MacInfoHeader(Inno_SubBlockHeader sb, byte[] macHeader)
	{
		super(sb);
		int pos = 0;
		fileType = Inno_Raw.readIntLittleEndian(macHeader, pos);
		pos+=4;
		fileCreator = Inno_Raw.readIntLittleEndian(macHeader, pos);
	}

	public int getFileCreator() {
		return fileCreator;
	}

	public void setFileCreator(int fileCreator) {
		this.fileCreator = fileCreator;
	}

	public int getFileType() {
		return fileType;
	}

	public void setFileType(int fileType) {
		this.fileType = fileType;
	}
	
	public void print(){
		super.print();
		logger.info("filetype: "+fileType);
		logger.info("creator :"+fileCreator);
	}
}