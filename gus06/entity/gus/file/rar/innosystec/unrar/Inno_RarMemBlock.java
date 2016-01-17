package gus06.entity.gus.file.rar.innosystec.unrar;

public class Inno_RarMemBlock extends Inno_Pointer
{
    public static final int size = 12;

	private int stamp, NU;

	private int next, prev; // Pointer RarMemBlock

	public Inno_RarMemBlock(byte[] mem)
	{
		super(mem);
	}

    public void insertAt(Inno_RarMemBlock p)
	{
		Inno_RarMemBlock temp = new Inno_RarMemBlock(mem);
		setPrev(p.getAddress());
		temp.setAddress(getPrev());
		setNext(temp.getNext());// prev.getNext();
		temp.setNext(this);// prev.setNext(this);
		temp.setAddress(getNext());
		temp.setPrev(this);// next.setPrev(this);
	}

	public void remove()
	{
		Inno_RarMemBlock temp = new Inno_RarMemBlock(mem);
		temp.setAddress(getPrev());
		temp.setNext(getNext());// prev.setNext(next);
		temp.setAddress(getNext());
		temp.setPrev(getPrev());// next.setPrev(prev);
//		next = -1;
//		prev = -1;
	}

	public int getNext()
	{
		if(mem!=null){
			next = Inno_Raw.readIntLittleEndian(mem,  pos+4);
		}
		return next;
	}

	public void setNext(Inno_RarMemBlock next)
	{
		setNext(next.getAddress());
	}

	public void setNext(int next)
	{
		this.next = next;
		if (mem != null) {
			Inno_Raw.writeIntLittleEndian(mem, pos + 4, next);
		}
	}

	public int getNU()
	{
		if(mem!=null){
			NU = Inno_Raw.readShortLittleEndian(mem,  pos+2)&0xffff;
		}
		return NU;
	}

	public void setNU(int nu)
	{
		NU = nu&0xffff;
		if (mem != null) {
			Inno_Raw.writeShortLittleEndian(mem, pos + 2, (short)nu);
		}
	}

	public int getPrev()
	{
		if(mem!=null){
			prev = Inno_Raw.readIntLittleEndian(mem,  pos+8);
		}
		return prev;
	}

	public void setPrev(Inno_RarMemBlock prev)
	{
		setPrev(prev.getAddress());
	}

	public void setPrev(int prev)
	{
		this.prev = prev;
		if (mem != null) {
			Inno_Raw.writeIntLittleEndian(mem, pos + 8, prev);
		}
	}

	public int getStamp()
	{
		if(mem!=null){
			stamp =  Inno_Raw.readShortLittleEndian(mem,  pos)&0xffff;
		}
		return stamp;
	}

	public void setStamp(int stamp)
	{
		this.stamp = stamp;
		if (mem != null) {
			Inno_Raw.writeShortLittleEndian(mem, pos, (short)stamp);
		}
	}
}