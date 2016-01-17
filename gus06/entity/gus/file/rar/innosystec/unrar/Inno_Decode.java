package gus06.entity.gus.file.rar.innosystec.unrar;

public class Inno_Decode
{
	private int maxNum;
	private final int[] decodeLen = new int[16];
	private final int[] decodePos = new int[16];
	protected int[] decodeNum = new int[2];

	public int[] getDecodeLen()		{return decodeLen;}
	public int[] getDecodeNum()		{return decodeNum;}
	public int[] getDecodePos()		{return decodePos;}
	public int getMaxNum()			{return maxNum;}
	public void setMaxNum(int maxNum)	{this.maxNum = maxNum;}
}