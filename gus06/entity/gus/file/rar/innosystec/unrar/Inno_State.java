package gus06.entity.gus.file.rar.innosystec.unrar;

public class Inno_State extends Inno_Pointer {

	public static final int size = 6;

	public Inno_State(byte[] mem) {
		super(mem);
	}

    public Inno_State init(byte[] mem) {
		this.mem = mem;
        pos = 0;
        return this;
    }

	public int getSymbol() {
        return mem[pos]&0xff;
	}

	public void setSymbol(int symbol) {
        mem[pos] = (byte)symbol;
	}

	public int getFreq() {
        return mem[pos+1]&0xff;
	}

	public void setFreq(int freq) {
        mem[pos + 1] = (byte)freq;
	}

    public void incFreq(int dFreq) {
        mem[pos + 1] += dFreq;
    }
	
	public int getSuccessor() {
        return Inno_Raw.readIntLittleEndian(mem, pos+2);
	}

	public void setSuccessor(Inno_PPMContext successor) {
		setSuccessor(successor.getAddress());
	}

	public void setSuccessor(int successor) {
        Inno_Raw.writeIntLittleEndian(mem, pos + 2, successor);
	}

	public void setValues(Inno_StateRef state){
		setSymbol(state.getSymbol());
		setFreq(state.getFreq());
		setSuccessor(state.getSuccessor());
	}

	public void setValues(Inno_State ptr){
        System.arraycopy(ptr.mem, ptr.pos, mem, pos, size);
	}

	public Inno_State decAddress(){
		setAddress(pos-size);
		return this;
	}

    public Inno_State incAddress(){
		setAddress(pos+size);
		return this;
	}

    public static void ppmdSwap(Inno_State ptr1, Inno_State ptr2) {
        byte[] mem1=ptr1.mem, mem2=ptr2.mem;
		for (int i=0, pos1=ptr1.pos, pos2=ptr2.pos; i < size; i++, pos1++, pos2++) {
			byte temp = mem1[pos1];
			mem1[pos1] = mem2[pos2];
			mem2[pos2] = temp;
		}
    }

    public String toString() {
        StringBuilder buffer = new StringBuilder();
        buffer.append("State[");
        buffer.append("\n  pos=");
        buffer.append(pos);
        buffer.append("\n  size=");
        buffer.append(size);
        buffer.append("\n  symbol=");
        buffer.append(getSymbol());
        buffer.append("\n  freq=");
        buffer.append(getFreq());
        buffer.append("\n  successor=");
        buffer.append(getSuccessor());
        buffer.append("\n]");
        return buffer.toString();
    }
}