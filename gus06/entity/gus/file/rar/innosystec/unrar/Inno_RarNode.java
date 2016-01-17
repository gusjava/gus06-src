package gus06.entity.gus.file.rar.innosystec.unrar;

public class Inno_RarNode extends Inno_Pointer{
	private int next; //rarnode pointer

	public static final int size = 4;
	
	public Inno_RarNode(byte[] mem)
	{super(mem);}
	
	public int getNext()
	{
		if(mem!=null) next = Inno_Raw.readIntLittleEndian(mem,  pos);
		return next;
	}

	public void setNext(Inno_RarNode next)
	{setNext(next.getAddress());}
	
	public void setNext(int next)
	{
		this.next = next;
		if(mem!=null) Inno_Raw.writeIntLittleEndian(mem, pos, next);
	}

	public String toString()
{
		StringBuilder buffer = new StringBuilder();
		buffer.append("State[");
		buffer.append("\n  pos=");
		buffer.append(pos);
		buffer.append("\n  size=");
		buffer.append(size);
		buffer.append("\n  next=");
		buffer.append(getNext());
		buffer.append("\n]");
		return buffer.toString();
	}
}