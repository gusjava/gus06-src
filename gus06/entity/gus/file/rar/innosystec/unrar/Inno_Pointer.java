package gus06.entity.gus.file.rar.innosystec.unrar;

public abstract class Inno_Pointer
{
	protected byte[] mem;
	protected int pos;
	
	public Inno_Pointer(byte[] mem){
		this.mem = mem;
	}
	
	public int getAddress(){
        assert (mem != null);
		return pos;
	}

	public void setAddress(int pos) {
        assert (mem != null);
        assert (pos >= 0) && (pos < mem.length) : pos;
        this.pos = pos;
    }
}