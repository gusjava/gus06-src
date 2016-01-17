package gus06.entity.gus.file.rar.innosystec.unrar;

public enum Inno_BlockTypes
{
	BLOCK_LZ(0), BLOCK_PPM(1);

	private int blockType;

	private Inno_BlockTypes(int blockType)
	{this.blockType = blockType;}

	public int getBlockType()
	{return blockType;}

	public boolean equals(int blockType)
	{return this.blockType == blockType;}


	public static Inno_BlockTypes findBlockType(int blockType)
	{
		if (BLOCK_LZ.equals(blockType))		return BLOCK_LZ;
		if (BLOCK_PPM.equals(blockType))	return BLOCK_PPM;
		return null;
	}
}