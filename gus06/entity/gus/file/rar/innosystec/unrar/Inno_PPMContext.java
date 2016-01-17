package gus06.entity.gus.file.rar.innosystec.unrar;

public class Inno_PPMContext extends Inno_Pointer
{

    private static final int unionSize = Math.max(Inno_FreqData.size, Inno_State.size);

	public static final int size = 2 + unionSize + 4; // 12

    // ushort NumStats;
	private int numStats; // determines if feqData or onstate is used

	// (1==onestate)

	private final Inno_FreqData freqData; // -\

	// |-> union
	private final Inno_State oneState; // -/

	private int suffix; // pointer ppmcontext

	public final static int[] ExpEscape =
            { 25, 14, 9, 7, 5, 5, 4, 4, 4, 3, 3, 3, 2, 2, 2, 2 };

    // Temp fields
    private final Inno_State tempState1 = new Inno_State(null);
    private final Inno_State tempState2 = new Inno_State(null);
    private final Inno_State tempState3 = new Inno_State(null);
    private final Inno_State tempState4 = new Inno_State(null);
    private final Inno_State tempState5 = new Inno_State(null);
    private Inno_PPMContext tempPPMContext = null;
    private final int[] ps = new int[256];

	public Inno_PPMContext(byte[] mem)
	{
		super(mem);
		oneState = new Inno_State(mem);
		freqData = new Inno_FreqData(mem);
	}

    public Inno_PPMContext init(byte[] mem) {
		this.mem = mem;
        pos = 0;
		oneState.init(mem);
		freqData.init(mem);
        return this;
    }

	public Inno_FreqData getFreqData()
	{
		return freqData;
	}

	public void setFreqData(Inno_FreqData freqData)
	{
		this.freqData.setSummFreq(freqData.getSummFreq());
		this.freqData.setStats(freqData.getStats());
	}

	public final int getNumStats()
	{
		if (mem!=null){
			numStats = Inno_Raw.readShortLittleEndian(mem,  pos)&0xffff;
		}
		return numStats;
	}

	public final void setNumStats(int numStats)
	{
		this.numStats = numStats&0xffff;
		if (mem != null) {
			Inno_Raw.writeShortLittleEndian(mem, pos, (short)numStats);
		}
	}

	public Inno_State getOneState()
	{
		return oneState;
	}

	public void setOneState(Inno_StateRef oneState)
	{
		this.oneState.setValues(oneState);
	}

	public int getSuffix()
	{
		if(mem!=null){
			suffix = Inno_Raw.readIntLittleEndian(mem,  pos+8);
		}
		return suffix;
	}

	public void setSuffix(Inno_PPMContext suffix)
	{
		setSuffix(suffix.getAddress());
	}

	public void setSuffix(int suffix)
	{
		this.suffix = suffix;
		if (mem != null) {
			Inno_Raw.writeIntLittleEndian(mem, pos + 8, suffix);
		}
	}

	@Override
	public void setAddress(int pos)
	{
        super.setAddress(pos);
        oneState.setAddress(pos+2);
        freqData.setAddress(pos+2);
	}

    private Inno_PPMContext getTempPPMContext(byte[] mem) {
        if (tempPPMContext == null) {
            tempPPMContext = new Inno_PPMContext(null);
        }
        return tempPPMContext.init(mem);
    }

	public int createChild(Inno_ModelPPM model, Inno_State pStats/* ptr */,
			Inno_StateRef firstState /* ref */)
	{
		Inno_PPMContext pc = getTempPPMContext(model.getSubAlloc().getHeap());
		pc.setAddress(model.getSubAlloc().allocContext()); 
		if (pc != null) { 
			pc.setNumStats(1);
			pc.setOneState(firstState);
			pc.setSuffix(this);
			pStats.setSuccessor(pc);
		}
		return pc.getAddress();
	}

	public void rescale(Inno_ModelPPM model)
	{
		int OldNS = getNumStats(), i = getNumStats() - 1, Adder, EscFreq;
		// STATE* p1, * p;
		Inno_State p1 = new Inno_State(model.getHeap());
		Inno_State p = new Inno_State(model.getHeap());
		Inno_State temp = new Inno_State(model.getHeap());

		for (p.setAddress(model.getFoundState().getAddress());
                p.getAddress() != freqData.getStats();
                p.decAddress()) {
			temp.setAddress(p.getAddress() - Inno_State.size);
			Inno_State.ppmdSwap(p, temp);
		}
		temp.setAddress(freqData.getStats());
		temp.incFreq(4);
		freqData.incSummFreq(4);
		EscFreq = freqData.getSummFreq() - p.getFreq();
		Adder = (model.getOrderFall() != 0) ? 1 : 0;
		p.setFreq((p.getFreq() + Adder) >>> 1);
		freqData.setSummFreq(p.getFreq());
		do {
            p.incAddress();
			EscFreq -= p.getFreq();
			p.setFreq((p.getFreq() + Adder) >>> 1);
			freqData.incSummFreq(p.getFreq());
			temp.setAddress(p.getAddress() - Inno_State.size);
			if (p.getFreq() > temp.getFreq()) {
				p1.setAddress(p.getAddress());
                Inno_StateRef tmp = new Inno_StateRef();
                tmp.setValues(p1);
				Inno_State temp2 = new Inno_State(model.getHeap());
				Inno_State temp3 = new Inno_State(model.getHeap());
				do {
					// p1[0]=p1[-1];
					temp2.setAddress(p1.getAddress() - Inno_State.size);
					p1.setValues(temp2);
                    p1.decAddress();
					temp3.setAddress(p1.getAddress() - Inno_State.size);
				} while (p1.getAddress() != freqData.getStats() && tmp.getFreq() > temp3.getFreq());
				p1.setValues(tmp);
			}
		} while (--i != 0);
		if (p.getFreq() == 0) {
			do {
				i++;
				p.decAddress();
			} while (p.getFreq() == 0);
			EscFreq += i;
            setNumStats(getNumStats() - i);
			if (getNumStats() == 1) {
				Inno_StateRef tmp = new Inno_StateRef();
				temp.setAddress(freqData.getStats());
				tmp.setValues(temp);
				// STATE tmp=*U.Stats;
				do {
                    // tmp.Freq-=(tmp.Freq >> 1)
					tmp.decFreq(tmp.getFreq() >>> 1);
					EscFreq >>>= 1;
				} while (EscFreq > 1);
				model.getSubAlloc().freeUnits(freqData.getStats(),(OldNS + 1) >>> 1);
				oneState.setValues(tmp);
				model.getFoundState().setAddress(oneState.getAddress());
				return;
			}
		}
		EscFreq -= EscFreq >>> 1;
		freqData.incSummFreq(EscFreq);
		int n0 = (OldNS + 1) >>> 1, n1 = (getNumStats() + 1) >>> 1;
		if (n0 != n1) {
			freqData.setStats(model.getSubAlloc().shrinkUnits(freqData.getStats(), n0, n1));
		}
		model.getFoundState().setAddress(freqData.getStats());
	}

	private int getArrayIndex(Inno_ModelPPM Model, Inno_State rs)
	{
		Inno_PPMContext tempSuffix = getTempPPMContext(Model.getSubAlloc().getHeap());
		tempSuffix.setAddress(getSuffix());
		int ret = 0;
		ret += Model.getPrevSuccess();
		ret += Model.getNS2BSIndx()[tempSuffix.getNumStats() - 1];
		ret += Model.getHiBitsFlag() + 2* Model.getHB2Flag()[rs.getSymbol()];
		ret += ((Model.getRunLength() >>> 26) & 0x20);
		return ret;
	}

    public int getMean(int summ, int shift, int round)
	{
		return ( (summ + (1 << (shift - round) ) ) >>> (shift) );
	}

	public void decodeBinSymbol(Inno_ModelPPM model)
	{
		Inno_State rs = tempState1.init(model.getHeap());
		rs.setAddress(oneState.getAddress());// State&
		model.setHiBitsFlag(model.getHB2Flag()[model.getFoundState().getSymbol()]);
		int off1 = rs.getFreq() - 1;
		int off2 = getArrayIndex(model, rs);
		int bs = model.getBinSumm()[off1][off2];
		if (model.getCoder().getCurrentShiftCount(Inno_ModelPPM.TOT_BITS) < bs) {
			model.getFoundState().setAddress(rs.getAddress());
			rs.incFreq((rs.getFreq() < 128) ? 1 : 0);
			model.getCoder().getSubRange().setLowCount(0);
			model.getCoder().getSubRange().setHighCount(bs); 
			bs = ((bs + Inno_ModelPPM.INTERVAL - getMean(bs, Inno_ModelPPM.PERIOD_BITS, 2)) & 0xffff);
			model.getBinSumm()[off1][off2] = bs;
			model.setPrevSuccess(1); 
			model.incRunLength(1);
		} else {
			model.getCoder().getSubRange().setLowCount(bs);
			bs = (bs - getMean(bs, Inno_ModelPPM.PERIOD_BITS, 2)) & 0xFFFF;
			model.getBinSumm()[off1][off2] = bs;
			model.getCoder().getSubRange().setHighCount(Inno_ModelPPM.BIN_SCALE);
			model.setInitEsc(ExpEscape[bs >>> 10]);
			model.setNumMasked(1);
			model.getCharMask()[rs.getSymbol()] = model.getEscCount();
			model.setPrevSuccess(0);
			model.getFoundState().setAddress(0);
		}
		//int a = 0;//TODO just 4 debugging
	}

//	public static void ppmdSwap(ModelPPM model, StatePtr state1, StatePtr state2)
//	{
//		byte[] bytes = model.getSubAlloc().getHeap();
//		int p1 = state1.getAddress();
//		int p2 = state2.getAddress();
//		
//		for (int i = 0; i < StatePtr.size; i++) {
//			byte temp = bytes[p1+i];
//			bytes[p1+i] = bytes[p2+i];
//			bytes[p2+i] = temp;
//		}
//		state1.setAddress(p1);
//		state2.setAddress(p2);
//	}

	public void update1(Inno_ModelPPM model, int p/* ptr */)
	{
		model.getFoundState().setAddress(p);
		model.getFoundState().incFreq(4);
		freqData.incSummFreq(4);
		Inno_State p0 = tempState3.init(model.getHeap());
		Inno_State p1 = tempState4.init(model.getHeap());
		p0.setAddress(p);
		p1.setAddress(p - Inno_State.size);
		if (p0.getFreq() > p1.getFreq()) {
			Inno_State.ppmdSwap(p0, p1);
			model.getFoundState().setAddress(p1.getAddress());
			if (p1.getFreq() > Inno_ModelPPM.MAX_FREQ)
				rescale(model);
		}
	}

	public boolean decodeSymbol2(Inno_ModelPPM model)
	{
		long count;
        int hiCnt, i = getNumStats() - model.getNumMasked();
		Inno_SEE2Context psee2c = makeEscFreq2(model, i);
		Inno_RangeCoder coder = model.getCoder();
		// STATE* ps[256], ** pps=ps, * p=U.Stats-1;
		Inno_State p = tempState1.init(model.getHeap());
		Inno_State temp = tempState2.init(model.getHeap());
		p.setAddress(freqData.getStats() - Inno_State.size); 
		int pps = 0;
		hiCnt = 0;

		do {
			do {
				p.incAddress();// p++;
			} while (model.getCharMask()[p.getSymbol()] == model.getEscCount());
			hiCnt += p.getFreq();
			ps[pps++] = p.getAddress();
		} while (--i != 0);
		coder.getSubRange().incScale(hiCnt);
		count = coder.getCurrentCount();
		if (count >= coder.getSubRange().getScale()) {
			return false;
		}
		pps = 0;
		p.setAddress(ps[pps]);
		if (count < hiCnt) {
			hiCnt = 0;
			while ((hiCnt += p.getFreq()) <= count) {
				p.setAddress(ps[++pps]);// p=*++pps;
			}
			coder.getSubRange().setHighCount(hiCnt);
			coder.getSubRange().setLowCount(hiCnt - p.getFreq());
			psee2c.update();
			update2(model, p.getAddress());
		} else {
			coder.getSubRange().setLowCount(hiCnt);
			coder.getSubRange().setHighCount(coder.getSubRange().getScale());
			i = getNumStats() - model.getNumMasked();// ->NumMasked;
			pps--;
			do {
				temp.setAddress(ps[++pps]);// (*++pps)
				model.getCharMask()[temp.getSymbol()] = model.getEscCount();
			} while (--i != 0);
			psee2c.incSumm((int)coder.getSubRange().getScale());
			model.setNumMasked(getNumStats());
		}
		return (true);
	}

	public void update2(Inno_ModelPPM model, int p/* state ptr */)
	{
		Inno_State temp = tempState5.init(model.getHeap());
		temp.setAddress(p);
		model.getFoundState().setAddress(p);
		model.getFoundState().incFreq(4); 
		freqData.incSummFreq(4);
		if (temp.getFreq() > Inno_ModelPPM.MAX_FREQ) {
			rescale(model);
		}
		model.incEscCount(1);
		model.setRunLength(model.getInitRL());
	}

	private Inno_SEE2Context makeEscFreq2(Inno_ModelPPM model, int Diff)
	{
		Inno_SEE2Context psee2c;
        int numStats = getNumStats();
		if (numStats != 256) {
			Inno_PPMContext suff = getTempPPMContext(model.getHeap());
			suff.setAddress(getSuffix());
            int idx1 = model.getNS2Indx()[Diff - 1];
            int idx2 = 0;
            idx2 += (Diff < suff.getNumStats() - numStats) ? 1 : 0;
			idx2 += 2 * ((freqData.getSummFreq() < 11 * numStats) ? 1 : 0); 
			idx2 += 4 * ((model.getNumMasked() > Diff) ? 1 : 0); 
			idx2 += model.getHiBitsFlag();
			psee2c = model.getSEE2Cont()[idx1][idx2];
			model.getCoder().getSubRange().setScale(psee2c.getMean());
		} else {
			psee2c = model.getDummySEE2Cont();
			model.getCoder().getSubRange().setScale(1);
		}
		return psee2c;
	}

	public boolean decodeSymbol1(Inno_ModelPPM model)
	{

		Inno_RangeCoder coder = model.getCoder();
		coder.getSubRange().setScale(freqData.getSummFreq());
		Inno_State p = new Inno_State(model.getHeap());
		p.setAddress(freqData.getStats());
		int i, HiCnt;
		long count = coder.getCurrentCount();
		if (count >= coder.getSubRange().getScale()) {
			return false;
		}
		if (count < (HiCnt = p.getFreq())) {
			coder.getSubRange().setHighCount(HiCnt);
			model.setPrevSuccess((2 * HiCnt > coder.getSubRange().getScale()) ? 1 : 0);
			model.incRunLength(model.getPrevSuccess());
			HiCnt += 4;
			model.getFoundState().setAddress(p.getAddress());
			model.getFoundState().setFreq(HiCnt);
			freqData.incSummFreq(4);
			if (HiCnt > Inno_ModelPPM.MAX_FREQ) {
				rescale(model);
			}
			coder.getSubRange().setLowCount(0);
			return true;
		} else {
			if (model.getFoundState().getAddress() == 0) {
				return (false);
			}
		}
		model.setPrevSuccess(0);
        int numStats = getNumStats();
		i = numStats - 1;
		while ((HiCnt += p.incAddress().getFreq()) <= count)
		{
			if (--i == 0) {
				model.setHiBitsFlag(model.getHB2Flag()[model.getFoundState().getSymbol()]);
				coder.getSubRange().setLowCount(HiCnt);
				model.getCharMask()[p.getSymbol()] = model.getEscCount();
				model.setNumMasked(numStats);
				i = numStats - 1;
				model.getFoundState().setAddress(0);
				do {
					model.getCharMask()[p.decAddress().getSymbol()] = model.getEscCount();
				} while (--i != 0);
				coder.getSubRange().setHighCount(coder.getSubRange().getScale());
				return (true);
			}
		}
		coder.getSubRange().setLowCount(HiCnt-p.getFreq());
		coder.getSubRange().setHighCount(HiCnt);
		update1(model, p.getAddress());
		return (true);
	}

    public String toString() {
        StringBuilder buffer = new StringBuilder();
        buffer.append("PPMContext[");
        buffer.append("\n  pos=");
        buffer.append(pos);
        buffer.append("\n  size=");
        buffer.append(size);
        buffer.append("\n  numStats=");
        buffer.append(getNumStats());
        buffer.append("\n  Suffix=");
        buffer.append(getSuffix());
        buffer.append("\n  freqData=");
        buffer.append(freqData);
        buffer.append("\n  oneState=");
        buffer.append(oneState);
        buffer.append("\n]");
        return buffer.toString();
    }

}