package gus06.entity.gus.file.rar.innosystec.unrar;

public class Inno_FreqData extends Inno_Pointer{

	public static final int size = 6; 

//    struct FreqData
//    {
//        ushort SummFreq;
//        STATE _PACK_ATTR * Stats;
//    };

	public Inno_FreqData(byte[]mem){
		super(mem);
	}

    public Inno_FreqData init(byte[] mem) {
        this.mem = mem;
        pos = 0;
        return this;
    }

    public int getSummFreq() {
		return Inno_Raw.readShortLittleEndian(mem,  pos)&0xffff;
	}

	public void setSummFreq(int summFreq) {
        Inno_Raw.writeShortLittleEndian(mem, pos, (short)summFreq);
	}

    public void incSummFreq(int dSummFreq) {
        Inno_Raw.incShortLittleEndian(mem, pos, dSummFreq);
    }

    public int getStats() {
        return Inno_Raw.readIntLittleEndian(mem,  pos+2);
	}

	public void setStats(Inno_State state) {
		setStats(state.getAddress());
	}

    public void setStats(int state) {
        Inno_Raw.writeIntLittleEndian(mem, pos+2, state);
	}

    public String toString() {
        StringBuilder buffer = new StringBuilder();
        buffer.append("FreqData[");
        buffer.append("\n  pos=");
        buffer.append(pos);
        buffer.append("\n  size=");
        buffer.append(size);
        buffer.append("\n  summFreq=");
        buffer.append(getSummFreq());
        buffer.append("\n  stats=");
        buffer.append(getStats());
        buffer.append("\n]");
        return buffer.toString();
    }
	
}