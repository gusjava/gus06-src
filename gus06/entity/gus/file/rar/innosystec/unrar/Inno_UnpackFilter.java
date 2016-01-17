package gus06.entity.gus.file.rar.innosystec.unrar;

public class Inno_UnpackFilter {

	private int BlockStart;
	private int BlockLength;
	private int ExecCount;

	private boolean NextWindow;

	// position of parent filter in Filters array used as prototype for filter
	// in PrgStack array. Not defined for filters in Filters array.
	private int ParentFilter;

	private Inno_VMPreparedProgram Prg  = new Inno_VMPreparedProgram();

	public int getBlockLength() {
		return BlockLength;
	}

	public void setBlockLength(int blockLength) {
		BlockLength = blockLength;
	}

	public int getBlockStart() {
		return BlockStart;
	}

	public void setBlockStart(int blockStart) {
		BlockStart = blockStart;
	}

	public int getExecCount() {
		return ExecCount;
	}

	public void setExecCount(int execCount) {
		ExecCount = execCount;
	}

	public boolean isNextWindow() {
		return NextWindow;
	}

	public void setNextWindow(boolean nextWindow) {
		NextWindow = nextWindow;
	}

	public int getParentFilter() {
		return ParentFilter;
	}

	public void setParentFilter(int parentFilter) {
		ParentFilter = parentFilter;
	}

	public Inno_VMPreparedProgram getPrg() {
		return Prg;
	}

	public void setPrg(Inno_VMPreparedProgram prg) {
		Prg = prg;
	}

	
	
}