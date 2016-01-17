package gus06.entity.gus.file.rar.innosystec.unrar;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Inno_BlockHeader extends Inno_BaseBlock
{
	public static final short blockHeaderSize = 4;
	
	private Log logger = LogFactory.getLog(Inno_BlockHeader.class.getName());
	
	private int dataSize;
	private int packSize;
	
	public Inno_BlockHeader() {}
	
	public Inno_BlockHeader(Inno_BlockHeader bh)
	{
		super(bh);
		this.packSize = bh.getDataSize();
		this.dataSize = packSize;
		this.positionInFile = bh.getPositionInFile();
	}
	
	public Inno_BlockHeader(Inno_BaseBlock bb, byte[] blockHeader) 
	{
		super(bb);
		this.packSize = Inno_Raw.readIntLittleEndian(blockHeader, 0);
		this.dataSize  = this.packSize;
	}
	
	public int getDataSize() {return dataSize;}
	
	public int getPackSize() {return packSize;}
	
	public void print()
	{
		super.print();
		String s = "DataSize: "+getDataSize()+" packSize: "+getPackSize();
		logger.info(s);
	}
}