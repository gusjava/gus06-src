package gus06.entity.gus.file.rar.innosystec.unrar;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

public final class Inno_Unpack extends Inno_Unpack20 {

	private final Inno_ModelPPM ppm = new Inno_ModelPPM();

	private int ppmEscChar;
	private Inno_RarVM rarVM = new Inno_RarVM();
	private List<Inno_UnpackFilter> filters = new ArrayList<Inno_UnpackFilter>();
	private List<Inno_UnpackFilter> prgStack = new ArrayList<Inno_UnpackFilter>();
	private List<Integer> oldFilterLengths = new ArrayList<Integer>();
	private int lastFilter;
	private boolean tablesRead;
	private byte[] unpOldTable = new byte[Inno_Compress.HUFF_TABLE_SIZE];
	private Inno_BlockTypes unpBlockType;
	private boolean externalWindow;
	private long writtenFileSize;
	private boolean fileExtracted;
	private boolean ppmError;
	private int prevLowDist;
	private int lowDistRepCount;

	public static int[] DBitLengthCounts = { 4, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 14, 0, 12 };

	public Inno_Unpack(Inno_ComprDataIO DataIO)
	{
		unpIO = DataIO;
		window = null;
		externalWindow = false;
		suspended = false;
		unpAllBuf = false;
		unpSomeRead = false;
	}

	public void init(byte[] window)
	{
		if (window == null) {
			this.window = new byte[Inno_Compress.MAXWINSIZE];
		} else {
			this.window = window;
			externalWindow = true;
		}
		inAddr = 0;
		unpInitData(false);
	}

	public void doUnpack(int method, boolean solid) throws IOException, Inno_RarException
	{
		if (unpIO.getSubHeader().getUnpMethod() == 0x30) unstoreFile();
		
		switch (method)
		{
			case 15: // rar 1.5 compression
			unpack15(solid);
			break;
			case 20: // rar 2.x compression
			case 26: // files larger than 2GB
			unpack20(solid);
			break;
			case 29: // rar 3.x compression
			case 36: // alternative hash
			unpack29(solid);
			break;
		}
	}

	private void unstoreFile() throws IOException, Inno_RarException
	{
		byte[] buffer = new byte[0x10000];
		while (true) {
		int code = unpIO.unpRead(buffer, 0, (int) Math.min(buffer.length,
			destUnpSize));
		if (code == 0 || code == -1)
		break;
		code = code < destUnpSize ? code : (int) destUnpSize;
		unpIO.unpWrite(buffer, 0, code);
		if (destUnpSize >= 0)
		destUnpSize -= code;
		}
	}


	private void unpack29(boolean solid) throws IOException, Inno_RarException
	{
		int[] DDecode = new int[Inno_Compress.DC];
		byte[] DBits = new byte[Inno_Compress.DC];

		int Bits;

		if (DDecode[1] == 0)
		{
			int Dist = 0, BitLength = 0, Slot = 0;
			for (int I = 0; I < DBitLengthCounts.length; I++, BitLength++)
			{
				int count = DBitLengthCounts[I];
				for (int J = 0; J < count; J++, Slot++, Dist += (1 << BitLength))
				{
					DDecode[Slot] = Dist;
					DBits[Slot] = (byte) BitLength;
				}
			}
		}

		fileExtracted = true;

		if(!suspended)
		{
			unpInitData(solid);
			if(!unpReadBuf()) return;
			if((!solid || !tablesRead) && !readTables()) return;
		}

		if(ppmError) return;

		while (true)
		{
			unpPtr &= Inno_Compress.MAXWINMASK;

			if(inAddr > readBorder)
			{
				if(!unpReadBuf()) break;
			}
		
		// System.out.println(((wrPtr - unpPtr) &
		// Compress.MAXWINMASK)+":"+wrPtr+":"+unpPtr);
			if (((wrPtr - unpPtr) & Inno_Compress.MAXWINMASK) < 260 && wrPtr != unpPtr)
			{

				UnpWriteBuf();
				if (writtenFileSize > destUnpSize) return;
		
				if(suspended)
				{
					fileExtracted = false;
					return;
				}
			}
			if (unpBlockType == Inno_BlockTypes.BLOCK_PPM) {
			int Ch = ppm.decodeChar();
			if (Ch == -1) {
			ppmError = true;
			break;
			}
			if (Ch == ppmEscChar) {
			int NextCh = ppm.decodeChar();
			if (NextCh == 0) {
			if (!readTables()) {
				break;
			}
			continue;
			}
			if (NextCh == 2 || NextCh == -1) {
			break;
			}
			if (NextCh == 3) {
			if (!readVMCodePPM()) {
				break;
			}
			continue;
			}
			if (NextCh == 4) {
			int Distance = 0, Length = 0;
			boolean failed = false;
			for (int I = 0; I < 4 && !failed; I++) {
				int ch = ppm.decodeChar();
				if (ch == -1) {
				failed = true;
				} else {
				if (I == 3) {
					// Bug fixed
					Length = ch & 0xff;
				} else {
					// Bug fixed
					Distance = (Distance << 8) + (ch & 0xff);
				}
				}
			}
			if (failed) {
				break;
			}
			copyString(Length + 32, Distance + 2);
			continue;
			}
			if (NextCh == 5) {
			int Length = ppm.decodeChar();
			if (Length == -1) {
				break;
			}
			copyString(Length + 4, 1);
			continue;
			}
		}
		window[unpPtr++] = (byte) Ch;
		continue;
		}

		int Number = decodeNumber(LD);
		if (Number < 256) {
		window[unpPtr++] = (byte) Number;
		continue;
		}
		if (Number >= 271) {
		int Length = LDecode[Number -= 271] + 3;
		if ((Bits = LBits[Number]) > 0) {
			Length += getbits() >>> (16 - Bits);
			addbits(Bits);
		}

		int DistNumber = decodeNumber(DD);
		int Distance = DDecode[DistNumber] + 1;
		if ((Bits = DBits[DistNumber]) > 0) {
			if (DistNumber > 9) {
			if (Bits > 4) {
				Distance += ((getbits() >>> (20 - Bits)) << 4);
				addbits(Bits - 4);
			}
			if (lowDistRepCount > 0) {
				lowDistRepCount--;
				Distance += prevLowDist;
			} else {
				int LowDist = decodeNumber(LDD);
				if (LowDist == 16) {
				lowDistRepCount = Inno_Compress.LOW_DIST_REP_COUNT - 1;
				Distance += prevLowDist;
				} else {
				Distance += LowDist;
				prevLowDist = LowDist;
				}
			}
			} else {
			Distance += getbits() >>> (16 - Bits);
			addbits(Bits);
			}
		}

		if (Distance >= 0x2000) {
			Length++;
			if (Distance >= 0x40000L) {
			Length++;
			}
		}

		insertOldDist(Distance);
		insertLastMatch(Length, Distance);

		copyString(Length, Distance);
		continue;
		}
		if (Number == 256) {
		if (!readEndOfBlock()) {
			break;
		}
		continue;
		}
		if (Number == 257) {
		if (!readVMCode()) {
			break;
		}
		continue;
		}
		if (Number == 258) {
		if (lastLength != 0) {
			copyString(lastLength, lastDist);
		}
		continue;
		}
		if (Number < 263) {
		int DistNum = Number - 259;
		int Distance = oldDist[DistNum];
		for (int I = DistNum; I > 0; I--) {
			oldDist[I] = oldDist[I - 1];
		}
		oldDist[0] = Distance;

		int LengthNumber = decodeNumber(RD);
		int Length = LDecode[LengthNumber] + 2;
		if ((Bits = LBits[LengthNumber]) > 0) {
			Length += getbits() >>> (16 - Bits);
			addbits(Bits);
		}
		insertLastMatch(Length, Distance);
		copyString(Length, Distance);
		continue;
		}
		if (Number < 272) {
		int Distance = SDDecode[Number -= 263] + 1;
		if ((Bits = SDBits[Number]) > 0) {
			Distance += getbits() >>> (16 - Bits);
			addbits(Bits);
		}
		insertOldDist(Distance);
		insertLastMatch(2, Distance);
		copyString(2, Distance);
		continue;
		}
	}
	UnpWriteBuf();

	}

	private void UnpWriteBuf() throws IOException {
	int WrittenBorder = wrPtr;
	int WriteSize = (unpPtr - WrittenBorder) & Inno_Compress.MAXWINMASK;
	for (int I = 0; I < prgStack.size(); I++) {
		Inno_UnpackFilter flt = prgStack.get(I);
		if (flt == null) {
		continue;
		}
		if (flt.isNextWindow()) {
		flt.setNextWindow(false);// ->NextWindow=false;
		continue;
		}
		int BlockStart = flt.getBlockStart();// ->BlockStart;
		int BlockLength = flt.getBlockLength();// ->BlockLength;
		if (((BlockStart - WrittenBorder) & Inno_Compress.MAXWINMASK) < WriteSize) {
		if (WrittenBorder != BlockStart) {
			UnpWriteArea(WrittenBorder, BlockStart);
			WrittenBorder = BlockStart;
			WriteSize = (unpPtr - WrittenBorder) & Inno_Compress.MAXWINMASK;
		}
		if (BlockLength <= WriteSize) {
			int BlockEnd = (BlockStart + BlockLength)
				& Inno_Compress.MAXWINMASK;
			if (BlockStart < BlockEnd || BlockEnd == 0) {
			// VM.SetMemory(0,Window+BlockStart,BlockLength);
			rarVM.setMemory(0, window, BlockStart, BlockLength);
			} else {
			int FirstPartLength = Inno_Compress.MAXWINSIZE - BlockStart;
			// VM.SetMemory(0,Window+BlockStart,FirstPartLength);
			rarVM.setMemory(0, window, BlockStart, FirstPartLength);
			// VM.SetMemory(FirstPartLength,Window,BlockEnd);
			rarVM.setMemory(FirstPartLength, window, 0, BlockEnd);

			}

			Inno_VMPreparedProgram ParentPrg = filters.get(
				flt.getParentFilter()).getPrg();
			Inno_VMPreparedProgram Prg = flt.getPrg();

			if (ParentPrg.getGlobalData().size() > Inno_RarVM.VM_FIXEDGLOBALSIZE) {
			// copy global data from previous script execution if
			// any
			// Prg->GlobalData.Alloc(ParentPrg->GlobalData.Size());
			// memcpy(&Prg->GlobalData[VM_FIXEDGLOBALSIZE],&ParentPrg->GlobalData[VM_FIXEDGLOBALSIZE],ParentPrg->GlobalData.Size()-VM_FIXEDGLOBALSIZE);
			Prg.getGlobalData().setSize(
				ParentPrg.getGlobalData().size());
			for (int i = 0; i < ParentPrg.getGlobalData().size()
				- Inno_RarVM.VM_FIXEDGLOBALSIZE; i++) {
				Prg.getGlobalData().set(
					Inno_RarVM.VM_FIXEDGLOBALSIZE + i,
					ParentPrg.getGlobalData().get(
						Inno_RarVM.VM_FIXEDGLOBALSIZE + i));
			}
			}

			ExecuteCode(Prg);

			if (Prg.getGlobalData().size() > Inno_RarVM.VM_FIXEDGLOBALSIZE) {
			// save global data for next script execution
			if (ParentPrg.getGlobalData().size() < Prg
				.getGlobalData().size()) {
				ParentPrg.getGlobalData().setSize(
					Prg.getGlobalData().size());// ->GlobalData.Alloc(Prg->GlobalData.Size());
			}
			// memcpy(&ParentPrg->GlobalData[VM_FIXEDGLOBALSIZE],&Prg->GlobalData[VM_FIXEDGLOBALSIZE],Prg->GlobalData.Size()-VM_FIXEDGLOBALSIZE);
			for (int i = 0; i < Prg.getGlobalData().size()
				- Inno_RarVM.VM_FIXEDGLOBALSIZE; i++) {
				ParentPrg.getGlobalData().set(
					Inno_RarVM.VM_FIXEDGLOBALSIZE + i,
					Prg.getGlobalData().get(
						Inno_RarVM.VM_FIXEDGLOBALSIZE + i));
			}
			} else {
			ParentPrg.getGlobalData().clear();
			}

			int FilteredDataOffset = Prg.getFilteredDataOffset();
			int FilteredDataSize = Prg.getFilteredDataSize();
			byte[] FilteredData = new byte[FilteredDataSize];

			for (int i = 0; i < FilteredDataSize; i++) {
			FilteredData[i] = rarVM.getMem()[FilteredDataOffset + i];// Prg.getGlobalData().get(FilteredDataOffset
										 // +
										 // i);
			}

			prgStack.set(I, null);
			while (I + 1 < prgStack.size()) {
			Inno_UnpackFilter NextFilter = prgStack.get(I + 1);
			if (NextFilter == null
				|| NextFilter.getBlockStart() != BlockStart
				|| NextFilter.getBlockLength() != FilteredDataSize
				|| NextFilter.isNextWindow()) {
				break;
			}
			// apply several filters to same data block

			rarVM.setMemory(0, FilteredData, 0, FilteredDataSize);// .SetMemory(0,FilteredData,FilteredDataSize);

			Inno_VMPreparedProgram pPrg = filters.get(
				NextFilter.getParentFilter()).getPrg();
			Inno_VMPreparedProgram NextPrg = NextFilter.getPrg();

			if (pPrg.getGlobalData().size() > Inno_RarVM.VM_FIXEDGLOBALSIZE) {
				// copy global data from previous script execution
				// if any
				// NextPrg->GlobalData.Alloc(ParentPrg->GlobalData.Size());
				NextPrg.getGlobalData().setSize(
					pPrg.getGlobalData().size());
				// memcpy(&NextPrg->GlobalData[VM_FIXEDGLOBALSIZE],&ParentPrg->GlobalData[VM_FIXEDGLOBALSIZE],ParentPrg->GlobalData.Size()-VM_FIXEDGLOBALSIZE);
				for (int i = 0; i < pPrg.getGlobalData().size()
					- Inno_RarVM.VM_FIXEDGLOBALSIZE; i++) {
				NextPrg.getGlobalData().set(
					Inno_RarVM.VM_FIXEDGLOBALSIZE + i,
					pPrg.getGlobalData().get(
						Inno_RarVM.VM_FIXEDGLOBALSIZE + i));
				}
			}

			ExecuteCode(NextPrg);

			if (NextPrg.getGlobalData().size() > Inno_RarVM.VM_FIXEDGLOBALSIZE) {
				// save global data for next script execution
				if (pPrg.getGlobalData().size() < NextPrg
					.getGlobalData().size()) {
				pPrg.getGlobalData().setSize(
					NextPrg.getGlobalData().size());
				}
				// memcpy(&ParentPrg->GlobalData[VM_FIXEDGLOBALSIZE],&NextPrg->GlobalData[VM_FIXEDGLOBALSIZE],NextPrg->GlobalData.Size()-VM_FIXEDGLOBALSIZE);
				for (int i = 0; i < NextPrg.getGlobalData().size()
					- Inno_RarVM.VM_FIXEDGLOBALSIZE; i++) {
				pPrg.getGlobalData().set(
					Inno_RarVM.VM_FIXEDGLOBALSIZE + i,
					NextPrg.getGlobalData().get(
						Inno_RarVM.VM_FIXEDGLOBALSIZE + i));
				}
			} else {
				pPrg.getGlobalData().clear();
			}
			FilteredDataOffset = NextPrg.getFilteredDataOffset();
			FilteredDataSize = NextPrg.getFilteredDataSize();

			FilteredData = new byte[FilteredDataSize];
			for (int i = 0; i < FilteredDataSize; i++) {
				FilteredData[i] = NextPrg.getGlobalData().get(
					FilteredDataOffset + i);
			}

			I++;
			prgStack.set(I, null);
			}
			unpIO.unpWrite(FilteredData, 0, FilteredDataSize);
			unpSomeRead = true;
			writtenFileSize += FilteredDataSize;
			WrittenBorder = BlockEnd;
			WriteSize = (unpPtr - WrittenBorder) & Inno_Compress.MAXWINMASK;
		} else {
			for (int J = I; J < prgStack.size(); J++) {
			Inno_UnpackFilter filt = prgStack.get(J);
			if (filt != null && filt.isNextWindow()) {
				filt.setNextWindow(false);
			}
			}
			wrPtr = WrittenBorder;
			return;
		}
		}
	}

	UnpWriteArea(WrittenBorder, unpPtr);
	wrPtr = unpPtr;

	}

	private void UnpWriteArea(int startPtr, int endPtr) throws IOException {
	if (endPtr != startPtr) {
		unpSomeRead = true;
	}
	if (endPtr < startPtr) {
		UnpWriteData(window, startPtr, -startPtr & Inno_Compress.MAXWINMASK);
		UnpWriteData(window, 0, endPtr);
		unpAllBuf = true;
	} else {
		UnpWriteData(window, startPtr, endPtr - startPtr);
	}
	}

	private void UnpWriteData(byte[] data, int offset, int size)
		throws IOException {
	if (writtenFileSize >= destUnpSize) {
		return;
	}
	int writeSize = size;
	long leftToWrite = destUnpSize - writtenFileSize;
	if (writeSize > leftToWrite) {
		writeSize = (int) leftToWrite;
	}
	unpIO.unpWrite(data, offset, writeSize);

	writtenFileSize += size;

	}

	private void insertOldDist(int distance) {
	oldDist[3] = oldDist[2];
	oldDist[2] = oldDist[1];
	oldDist[1] = oldDist[0];
	oldDist[0] = distance;
	}

	private void insertLastMatch(int length, int distance) {
	lastDist = distance;
	lastLength = length;
	}

	private void copyString(int length, int distance) {
	// System.out.println("copyString(" + length + ", " + distance + ")");

	int destPtr = unpPtr - distance;
	// System.out.println(unpPtr+":"+distance);
	if (destPtr >= 0 && destPtr < Inno_Compress.MAXWINSIZE - 260
		&& unpPtr < Inno_Compress.MAXWINSIZE - 260) {

		window[unpPtr++] = window[destPtr++];

		while (--length > 0)

		window[unpPtr++] = window[destPtr++];
	} else
		while (length-- != 0) {
		window[unpPtr] = window[destPtr++ & Inno_Compress.MAXWINMASK];
		unpPtr = (unpPtr + 1) & Inno_Compress.MAXWINMASK;
		}
	}

	protected void unpInitData(boolean solid) {
	if (!solid) {
		tablesRead = false;
		Arrays.fill(oldDist, 0); // memset(oldDist,0,sizeof(OldDist));

		oldDistPtr = 0;
		lastDist = 0;
		lastLength = 0;

		Arrays.fill(unpOldTable, (byte) 0);// memset(UnpOldTable,0,sizeof(UnpOldTable));

		unpPtr = 0;
		wrPtr = 0;
		ppmEscChar = 2;

		initFilters();
	}
	InitBitInput();
	ppmError = false;
	writtenFileSize = 0;
	readTop = 0;
	readBorder = 0;
	unpInitData20(solid);
	}

	private void initFilters() {
	oldFilterLengths.clear();
	lastFilter = 0;

	filters.clear();

	prgStack.clear();
	}

	private boolean readEndOfBlock() throws IOException, Inno_RarException {
	int BitField = getbits();
	boolean NewTable, NewFile = false;
	if ((BitField & 0x8000) != 0) {
		NewTable = true;
		addbits(1);
	} else {
		NewFile = true;
		NewTable = (BitField & 0x4000) != 0 ? true : false;
		addbits(2);
	}
	tablesRead = !NewTable;
	return !(NewFile || NewTable && !readTables());
	}

	private boolean readTables() throws IOException, Inno_RarException {
	byte[] bitLength = new byte[Inno_Compress.BC];

	byte[] table = new byte[Inno_Compress.HUFF_TABLE_SIZE];
	if (inAddr > readTop - 25) {
		if (!unpReadBuf()) {
		return (false);
		}
	}
	faddbits((8 - inBit) & 7);
	long bitField = fgetbits() & 0xffFFffFF;
	if ((bitField & 0x8000) != 0) {
		unpBlockType = Inno_BlockTypes.BLOCK_PPM;
		return (ppm.decodeInit(this, ppmEscChar));
	}
	unpBlockType = Inno_BlockTypes.BLOCK_LZ;

	prevLowDist = 0;
	lowDistRepCount = 0;

	if ((bitField & 0x4000) == 0) {
		Arrays.fill(unpOldTable, (byte) 0);// memset(UnpOldTable,0,sizeof(UnpOldTable));
	}
	faddbits(2);

	for (int i = 0; i < Inno_Compress.BC; i++) {
		int length = (fgetbits() >>> 12) & 0xFF;
		faddbits(4);
		if (length == 15) {
		int zeroCount = (fgetbits() >>> 12) & 0xFF;
		faddbits(4);
		if (zeroCount == 0) {
			bitLength[i] = 15;
		} else {
			zeroCount += 2;
			while (zeroCount-- > 0 && i < bitLength.length) {
			bitLength[i++] = 0;
			}
			i--;
		}
		} else {
		bitLength[i] = (byte) length;
		}
	}

	makeDecodeTables(bitLength, 0, BD, Inno_Compress.BC);

	int TableSize = Inno_Compress.HUFF_TABLE_SIZE;

	for (int i = 0; i < TableSize;) {
		if (inAddr > readTop - 5) {
		if (!unpReadBuf()) {
			return (false);
		}
		}
		int Number = decodeNumber(BD);
		if (Number < 16) {
		table[i] = (byte) ((Number + unpOldTable[i]) & 0xf);
		i++;
		} else if (Number < 18) {
		int N;
		if (Number == 16) {
			N = (fgetbits() >>> 13) + 3;
			faddbits(3);
		} else {
			N = (fgetbits() >>> 9) + 11;
			faddbits(7);
		}
		while (N-- > 0 && i < TableSize) {
			table[i] = table[i - 1];
			i++;
		}
		} else {
		int N;
		if (Number == 18) {
			N = (fgetbits() >>> 13) + 3;
			faddbits(3);
		} else {
			N = (fgetbits() >>> 9) + 11;
			faddbits(7);
		}
		while (N-- > 0 && i < TableSize) {
			table[i++] = 0;
		}
		}
	}
	tablesRead = true;
	if (inAddr > readTop) {
		return (false);
	}
	makeDecodeTables(table, 0, LD, Inno_Compress.NC);
	makeDecodeTables(table, Inno_Compress.NC, DD, Inno_Compress.DC);
	makeDecodeTables(table, Inno_Compress.NC + Inno_Compress.DC, LDD, Inno_Compress.LDC);
	makeDecodeTables(table, Inno_Compress.NC + Inno_Compress.DC + Inno_Compress.LDC, RD,
		Inno_Compress.RC);

	// memcpy(unpOldTable,table,sizeof(unpOldTable));
	for (int i = 0; i < unpOldTable.length; i++) {
		unpOldTable[i] = table[i];
	}
	return (true);

	}

	private boolean readVMCode() throws IOException, Inno_RarException {
	int FirstByte = getbits() >> 8;
	addbits(8);
	int Length = (FirstByte & 7) + 1;
	if (Length == 7) {
		Length = (getbits() >> 8) + 7;
		addbits(8);
	} else if (Length == 8) {
		Length = getbits();
		addbits(16);
	}
	List<Byte> vmCode = new ArrayList<Byte>();
	for (int I = 0; I < Length; I++) {
		if (inAddr >= readTop - 1 && !unpReadBuf() && I < Length - 1) {
		return (false);
		}
		vmCode.add(Byte.valueOf((byte) (getbits() >> 8)));
		addbits(8);
	}
	return (addVMCode(FirstByte, vmCode, Length));
	}

	private boolean readVMCodePPM() throws IOException, Inno_RarException {
	int FirstByte = ppm.decodeChar();
	if ((int) FirstByte == -1) {
		return (false);
	}
	int Length = (FirstByte & 7) + 1;
	if (Length == 7) {
		int B1 = ppm.decodeChar();
		if (B1 == -1) {
		return (false);
		}
		Length = B1 + 7;
	} else if (Length == 8) {
		int B1 = ppm.decodeChar();
		if (B1 == -1) {
		return (false);
		}
		int B2 = ppm.decodeChar();
		if (B2 == -1) {
		return (false);
		}
		Length = B1 * 256 + B2;
	}
	List<Byte> vmCode = new ArrayList<Byte>();
	for (int I = 0; I < Length; I++) {
		int Ch = ppm.decodeChar();
		if (Ch == -1) {
		return (false);
		}
		vmCode.add(Byte.valueOf((byte) Ch));// VMCode[I]=Ch;
	}
	return (addVMCode(FirstByte, vmCode, Length));
	}

	private boolean addVMCode(int firstByte, List<Byte> vmCode, int length) {
	Inno_BitInput Inp = new Inno_BitInput();
	Inp.InitBitInput();
	// memcpy(Inp.InBuf,Code,Min(BitInput::MAX_SIZE,CodeSize));
	for (int i = 0; i < Math.min(Inno_BitInput.MAX_SIZE, vmCode.size()); i++) {
		Inp.getInBuf()[i] = vmCode.get(i);
	}
	rarVM.init();

	int FiltPos;
	if ((firstByte & 0x80) != 0) {
		FiltPos = Inno_RarVM.ReadData(Inp);
		if (FiltPos == 0) {
		initFilters();
		} else {
		FiltPos--;
		}
	} else
		FiltPos = lastFilter; // use the same filter as last time

	if (FiltPos > filters.size() || FiltPos > oldFilterLengths.size()) {
		return (false);
	}
	lastFilter = FiltPos;
	boolean NewFilter = (FiltPos == filters.size());

	Inno_UnpackFilter StackFilter = new Inno_UnpackFilter(); // new filter for
	// PrgStack

	Inno_UnpackFilter Filter;
	if (NewFilter) // new filter code, never used before since VM reset
	{
		// too many different filters, corrupt archive
		if (FiltPos > 1024) {
		return (false);
		}

		// Filters[Filters.Size()-1]=Filter=new UnpackFilter;
		Filter = new Inno_UnpackFilter();
		filters.add(Filter);
		StackFilter.setParentFilter(filters.size() - 1);
		oldFilterLengths.add(0);
		Filter.setExecCount(0);
	} else // filter was used in the past
	{
		Filter = filters.get(FiltPos);
		StackFilter.setParentFilter(FiltPos);
		Filter.setExecCount(Filter.getExecCount() + 1);// ->ExecCount++;
	}

	prgStack.add(StackFilter);
	StackFilter.setExecCount(Filter.getExecCount());// ->ExecCount;

	int BlockStart = Inno_RarVM.ReadData(Inp);
	if ((firstByte & 0x40) != 0) {
		BlockStart += 258;
	}
	StackFilter.setBlockStart((BlockStart + unpPtr) & Inno_Compress.MAXWINMASK);
	if ((firstByte & 0x20) != 0) {
		StackFilter.setBlockLength(Inno_RarVM.ReadData(Inp));
	} else {
		StackFilter
			.setBlockLength(FiltPos < oldFilterLengths.size() ? oldFilterLengths
				.get(FiltPos)
				: 0);
	}
	StackFilter.setNextWindow((wrPtr != unpPtr)
		&& ((wrPtr - unpPtr) & Inno_Compress.MAXWINMASK) <= BlockStart);

	// DebugLog("\nNextWindow: UnpPtr=%08x WrPtr=%08x
	// BlockStart=%08x",UnpPtr,WrPtr,BlockStart);

	oldFilterLengths.set(FiltPos, StackFilter.getBlockLength());

	// memset(StackFilter->Prg.InitR,0,sizeof(StackFilter->Prg.InitR));
	Arrays.fill(StackFilter.getPrg().getInitR(), 0);
	StackFilter.getPrg().getInitR()[3] = Inno_RarVM.VM_GLOBALMEMADDR;// StackFilter->Prg.InitR[3]=VM_GLOBALMEMADDR;
	StackFilter.getPrg().getInitR()[4] = StackFilter.getBlockLength();// StackFilter->Prg.InitR[4]=StackFilter->BlockLength;
	StackFilter.getPrg().getInitR()[5] = StackFilter.getExecCount();// StackFilter->Prg.InitR[5]=StackFilter->ExecCount;

	if ((firstByte & 0x10) != 0) // set registers to optional parameters
	// if any
	{
		int InitMask = Inp.fgetbits() >>> 9;
		Inp.faddbits(7);
		for (int I = 0; I < 7; I++) {
		if ((InitMask & (1 << I)) != 0) {
			// StackFilter->Prg.InitR[I]=RarVM::ReadData(Inp);
			StackFilter.getPrg().getInitR()[I] = Inno_RarVM.ReadData(Inp);
		}
		}
	}

	if (NewFilter) {
		int VMCodeSize = Inno_RarVM.ReadData(Inp);
		if (VMCodeSize >= 0x10000 || VMCodeSize == 0) {
		return (false);
		}
		byte[] VMCode = new byte[VMCodeSize];
		for (int I = 0; I < VMCodeSize; I++) {
		if (Inp.Overflow(3)) {
			return (false);
		}
		VMCode[I] = (byte) (Inp.fgetbits() >> 8);
		Inp.faddbits(8);
		}
		// VM.Prepare(&VMCode[0],VMCodeSize,&Filter->Prg);
		rarVM.prepare(VMCode, VMCodeSize, Filter.getPrg());
	}
	StackFilter.getPrg().setAltCmd(Filter.getPrg().getCmd());// StackFilter->Prg.AltCmd=&Filter->Prg.Cmd[0];
	StackFilter.getPrg().setCmdCount(Filter.getPrg().getCmdCount());// StackFilter->Prg.CmdCount=Filter->Prg.CmdCount;

	int StaticDataSize = Filter.getPrg().getStaticData().size();
	if (StaticDataSize > 0 && StaticDataSize < Inno_RarVM.VM_GLOBALMEMSIZE) {
		// read statically defined data contained in DB commands
		// StackFilter->Prg.StaticData.Add(StaticDataSize);
		StackFilter.getPrg().setStaticData(Filter.getPrg().getStaticData());
		// memcpy(&StackFilter->Prg.StaticData[0],&Filter->Prg.StaticData[0],StaticDataSize);
	}

	if (StackFilter.getPrg().getGlobalData().size() < Inno_RarVM.VM_FIXEDGLOBALSIZE) {
		// StackFilter->Prg.GlobalData.Reset();
		// StackFilter->Prg.GlobalData.Add(VM_FIXEDGLOBALSIZE);
		StackFilter.getPrg().getGlobalData().clear();
		StackFilter.getPrg().getGlobalData().setSize(
			Inno_RarVM.VM_FIXEDGLOBALSIZE);
	}

	// byte *GlobalData=&StackFilter->Prg.GlobalData[0];
	Vector<Byte> globalData = StackFilter.getPrg().getGlobalData();
	for (int I = 0; I < 7; I++) {
		rarVM.setLowEndianValue(globalData, I * 4, StackFilter.getPrg()
			.getInitR()[I]);
	}

	// VM.SetLowEndianValue((uint
	// *)&GlobalData[0x1c],StackFilter->BlockLength);
	rarVM.setLowEndianValue(globalData, 0x1c, StackFilter.getBlockLength());
	// VM.SetLowEndianValue((uint *)&GlobalData[0x20],0);
	rarVM.setLowEndianValue(globalData, 0x20, 0);
	rarVM.setLowEndianValue(globalData, 0x24, 0);
	rarVM.setLowEndianValue(globalData, 0x28, 0);

	// VM.SetLowEndianValue((uint
	// *)&GlobalData[0x2c],StackFilter->ExecCount);
	rarVM.setLowEndianValue(globalData, 0x2c, StackFilter.getExecCount());
	// memset(&GlobalData[0x30],0,16);
	for (int i = 0; i < 16; i++) {
		globalData.set(0x30 + i, Byte.valueOf((byte) (0)));
	}
	if ((firstByte & 8) != 0) // put data block passed as parameter if any
	{
		if (Inp.Overflow(3)) {
		return (false);
		}
		int DataSize = Inno_RarVM.ReadData(Inp);
		if (DataSize > Inno_RarVM.VM_GLOBALMEMSIZE - Inno_RarVM.VM_FIXEDGLOBALSIZE) {
		return (false);
		}
		int CurSize = StackFilter.getPrg().getGlobalData().size();
		if (CurSize < DataSize + Inno_RarVM.VM_FIXEDGLOBALSIZE) {
		// StackFilter->Prg.GlobalData.Add(DataSize+VM_FIXEDGLOBALSIZE-CurSize);
		StackFilter.getPrg().getGlobalData().setSize(
			DataSize + Inno_RarVM.VM_FIXEDGLOBALSIZE - CurSize);
		}
		int offset = Inno_RarVM.VM_FIXEDGLOBALSIZE;
		globalData = StackFilter.getPrg().getGlobalData();
		for (int I = 0; I < DataSize; I++) {
		if (Inp.Overflow(3)) {
			return (false);
		}
		globalData.set(offset + I, Byte
			.valueOf((byte) (Inp.fgetbits() >>> 8)));
		Inp.faddbits(8);
		}
	}
	return (true);
	}

	private void ExecuteCode(Inno_VMPreparedProgram Prg) {
	if (Prg.getGlobalData().size() > 0) {
		// Prg->InitR[6]=int64to32(WrittenFileSize);
		Prg.getInitR()[6] = (int) (writtenFileSize);
		// rarVM.SetLowEndianValue((uint
		// *)&Prg->GlobalData[0x24],int64to32(WrittenFileSize));
		rarVM.setLowEndianValue(Prg.getGlobalData(), 0x24,
			(int) writtenFileSize);
		// rarVM.SetLowEndianValue((uint
		// *)&Prg->GlobalData[0x28],int64to32(WrittenFileSize>>32));
		rarVM.setLowEndianValue(Prg.getGlobalData(), 0x28,
			(int) (writtenFileSize >>> 32));
		rarVM.execute(Prg);
	}
	}

	// Duplicate method
	// private boolean ReadEndOfBlock() throws IOException, RarException
	// {
	// int BitField = getbits();
	// boolean NewTable, NewFile = false;
	// if ((BitField & 0x8000) != 0) {
	// NewTable = true;
	// addbits(1);
	// } else {
	// NewFile = true;
	// NewTable = (BitField & 0x4000) != 0;
	// addbits(2);
	// }
	// tablesRead = !NewTable;
	// return !(NewFile || NewTable && !readTables());
	// }

	public boolean isFileExtracted() {
	return fileExtracted;
	}

	public void setDestSize(long destSize) {
	this.destUnpSize = destSize;
	this.fileExtracted = false;
	}

	public void setSuspended(boolean suspended) {
	this.suspended = suspended;
	}

	public int getChar() throws IOException, Inno_RarException {
	if (inAddr > Inno_BitInput.MAX_SIZE - 30) {
		unpReadBuf();
	}
	return (inBuf[inAddr++] & 0xff);
	}

	public int getPpmEscChar() {
	return ppmEscChar;
	}

	public void setPpmEscChar(int ppmEscChar) {
	this.ppmEscChar = ppmEscChar;
	}

	public void cleanUp() {
	if (ppm != null) {
		Inno_SubAllocator allocator = ppm.getSubAlloc();
		if (allocator != null) {
		allocator.stopSubAllocator();
		}
	}
	}
}