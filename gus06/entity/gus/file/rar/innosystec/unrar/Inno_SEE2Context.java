package gus06.entity.gus.file.rar.innosystec.unrar;

public class Inno_SEE2Context {
	public static final int size = 4;
	private int summ;
	private int shift;
	private int count;

	public void init(int initVal)
	{
		shift = (Inno_ModelPPM.PERIOD_BITS - 4)&0xff;
		summ = (initVal << shift)&0xffff;
		count = 4;
	}

	public int getMean()
	{
		int retVal = summ >>> shift;
		summ -= retVal;
		return retVal + ((retVal == 0) ? 1 : 0);
	}

	public void update()
	{
		if (shift < Inno_ModelPPM.PERIOD_BITS && --count == 0)
		{
			summ += summ;
			count = (3 << shift++);
		}
		summ &= 0xffff;
		count &= 0xff;
		shift &= 0xff;
	}

	public int getCount() {return count;}

	public void setCount(int count) {
		this.count = count&0xff;
	}

	public int getShift() {return shift;}

	public void setShift(int shift) {this.shift = shift&0xff;}

	public int getSumm() {return summ;}

	public void setSumm(int summ) {this.summ = summ&0xffff;}

	public void incSumm(int dSumm) {
		setSumm(getSumm() + dSumm);
	}

	public String toString()
	{
		StringBuilder buffer = new StringBuilder();
		buffer.append("SEE2Context[");
		buffer.append("\n  size=");
		buffer.append(size);
		buffer.append("\n  summ=");
		buffer.append(summ);
		buffer.append("\n  shift=");
		buffer.append(shift);
		buffer.append("\n  count=");
		buffer.append(count);
		buffer.append("\n]");
		return buffer.toString();
	}
}