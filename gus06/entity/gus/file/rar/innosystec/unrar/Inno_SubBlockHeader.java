package gus06.entity.gus.file.rar.innosystec.unrar;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Inno_SubBlockHeader extends Inno_BlockHeader 
{
	private Log logger = LogFactory.getLog(getClass());
	
	public static final short SubBlockHeaderSize = 3;
	
	private short subType;
	private byte level;
	
	public Inno_SubBlockHeader(Inno_SubBlockHeader sb)
	{
		super(sb);
		subType = sb.getSubType().getSubblocktype();
		level = sb.getLevel();
	}
	
	public Inno_SubBlockHeader(Inno_BlockHeader bh, byte[] subblock)
	{
		super(bh);
		int position = 0;
		subType = Inno_Raw.readShortLittleEndian(subblock, position);
		position +=2;
		level |= subblock[position]&0xff;
	}

	/**
	 * @return
	 */
	public byte getLevel() {
		return level;
	}

	/**
	 * @return
	 */
	public Inno_SubBlockHeaderType getSubType() {
		return Inno_SubBlockHeaderType.findSubblockHeaderType(subType);
	}

	public void print()
	{
		super.print();
		logger.info("subtype: "+getSubType());
		logger.info("level: "+level);
	}
}