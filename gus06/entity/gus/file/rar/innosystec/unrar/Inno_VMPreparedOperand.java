package gus06.entity.gus.file.rar.innosystec.unrar;

public class Inno_VMPreparedOperand {
	private Inno_VMOpType Type;
	private int Data;
	private int Base;
	private int offset;
	
	
	public int getBase() {
		return Base;
	}
	public void setBase(int base) {
		Base = base;
	}
	public int getData() {
		return Data;
	}
	public void setData(int data) {
		Data = data;
	}
	public Inno_VMOpType getType() {
		return Type;
	}
	public void setType(Inno_VMOpType type) {
		Type = type;
	}
	public int getOffset() {
		return offset;
	}
	public void setOffset(int offset) {
		this.offset = offset;
	}
	 
}