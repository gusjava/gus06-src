package gus06.entity.gus.file.rar.innosystec.unrar;

public class Inno_VMPreparedCommand {
	private Inno_VMCommands OpCode;
	private boolean ByteMode;
	private Inno_VMPreparedOperand Op1 = new Inno_VMPreparedOperand();
	private Inno_VMPreparedOperand Op2 = new Inno_VMPreparedOperand();
	
	public boolean isByteMode() {
		return ByteMode;
	}
	public void setByteMode(boolean byteMode) {
		ByteMode = byteMode;
	}
	public Inno_VMPreparedOperand getOp1() {
		return Op1;
	}
	public void setOp1(Inno_VMPreparedOperand op1) {
		Op1 = op1;
	}
	public Inno_VMPreparedOperand getOp2() {
		return Op2;
	}
	public void setOp2(Inno_VMPreparedOperand op2) {
		Op2 = op2;
	}
	public Inno_VMCommands getOpCode() {
		return OpCode;
	}
	public void setOpCode(Inno_VMCommands opCode) {
		OpCode = opCode;
	}
	 
}