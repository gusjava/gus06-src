package gus06.entity.gus.file.rar.innosystec.unrar;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Inno_EAHeader extends Inno_SubBlockHeader 
{
	private Log logger = LogFactory.getLog(getClass());
	
	public static final short EAHeaderSize = 10;
	
	private int unpSize;
	private byte unpVer;
	private byte method;
	private int EACRC;
	
	public Inno_EAHeader(Inno_SubBlockHeader sb, byte[] eahead)
	{
		super(sb);
		int pos = 0;
		unpSize = Inno_Raw.readIntLittleEndian(eahead, pos);
		pos+=4;
		unpVer |= eahead[pos]&0xff;
		pos++;
		method |= eahead[pos]&0xff;
		pos++;
		EACRC = Inno_Raw.readIntLittleEndian(eahead, pos);
	}

	/**
	 * @return the eACRC
	 */
	public int getEACRC() {
		return EACRC;
	}

	/**
	 * @return the method
	 */
	public byte getMethod() {
		return method;
	}

	/**
	 * @return the unpSize
	 */
	public int getUnpSize() {
		return unpSize;
	}

	/**
	 * @return the unpVer
	 */
	public byte getUnpVer() {
		return unpVer;
	}
	
	public void print()
	{
		super.print();
		logger.info("unpSize: "+unpSize);
		logger.info("unpVersion: " + unpVer);
		logger.info("method: "+method);
		logger.info("EACRC:" + EACRC);
	}
}
