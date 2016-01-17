package gus06.entity.gus.file.rar.innosystec.unrar;

public enum Inno_HostSystem {
	msdos  ((byte)0),
	os2  ((byte)1),
	win32  ((byte)2),
	unix  ((byte)3),
	macos  ((byte)4),
	beos   ((byte)5);
	
	private byte hostByte;
	
	public static Inno_HostSystem findHostSystem(byte hostByte){
		if(Inno_HostSystem.msdos.equals(hostByte)){
			return Inno_HostSystem.msdos;
		}
		if(Inno_HostSystem.os2.equals(hostByte)){
			return Inno_HostSystem.os2;
		}
		if(Inno_HostSystem.win32.equals(hostByte)){
			return Inno_HostSystem.win32;
		}
		if(Inno_HostSystem.unix.equals(hostByte)){
			return Inno_HostSystem.unix;
		}
		if(Inno_HostSystem.macos.equals(hostByte)){
			return Inno_HostSystem.macos;
		}
		if(Inno_HostSystem.beos.equals(hostByte)){
			return Inno_HostSystem.beos;
		}
		return null;
	}
	
	
	private Inno_HostSystem(byte hostByte){
		this.hostByte = hostByte;
	}
	
	public boolean equals(byte hostByte){
		return this.hostByte == hostByte;
	}
	
	public byte getHostByte(){
		return hostByte;
	}
	//???? public static final byte max = 6; 
}