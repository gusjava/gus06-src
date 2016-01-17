package gus06.entity.gus.file.rar.innosystec.unrar;

public enum Inno_VMFlags {
	VM_FC (1),
	VM_FZ (2),
	VM_FS (0x80000000);
	
	private int flag;
	
	private Inno_VMFlags(int flag){
		this.flag = flag;
	}
	public static Inno_VMFlags findFlag(int flag){
		if(VM_FC.equals(flag)){
			return VM_FC;
		}
		if(VM_FS.equals(flag)){
			return VM_FS;
		}
		if(VM_FZ.equals(flag)){
			return VM_FZ;
		}
		return null;
	}
	public boolean equals(int flag){
		return this.flag == flag;
	}
	public int getFlag() {
		return flag;
	}
}