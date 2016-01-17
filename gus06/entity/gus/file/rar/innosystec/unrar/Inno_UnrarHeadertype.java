package gus06.entity.gus.file.rar.innosystec.unrar;

public enum Inno_UnrarHeadertype {
	
	MainHeader		((byte) 0x73),
	MarkHeader		((byte) 0x72),
	FileHeader 		((byte) 0x74),
	CommHeader  		((byte) 0x75),
	AvHeader 		((byte) 0x76),
	SubHeader 		((byte) 0x77),
	ProtectHeader  		((byte) 0x78),
	SignHeader 		((byte) 0x79),
	NewSubHeader 		((byte) 0x7a),
	EndArcHeader 		((byte) 0x7b);
	
	
	public static Inno_UnrarHeadertype findType(byte headerType) 
	{
		if(Inno_UnrarHeadertype.MarkHeader.equals(headerType)){
			return Inno_UnrarHeadertype.MarkHeader;
		}
		if(Inno_UnrarHeadertype.MainHeader.equals(headerType)){
			return Inno_UnrarHeadertype.MainHeader;
		}
		if(Inno_UnrarHeadertype.FileHeader.equals(headerType)){
			return Inno_UnrarHeadertype.FileHeader;
		}
		if(Inno_UnrarHeadertype.EndArcHeader.equals(headerType)){
			return Inno_UnrarHeadertype.EndArcHeader;
		}
		if(Inno_UnrarHeadertype.NewSubHeader.equals(headerType)){
			return Inno_UnrarHeadertype.NewSubHeader;
		}
		if(Inno_UnrarHeadertype.SubHeader.equals(headerType)){
			return Inno_UnrarHeadertype.SubHeader;
		}
		if(Inno_UnrarHeadertype.SignHeader.equals(headerType)){
			return Inno_UnrarHeadertype.SignHeader;
		}
		if(Inno_UnrarHeadertype.ProtectHeader.equals(headerType)){
			return Inno_UnrarHeadertype.ProtectHeader;
		}
		if(Inno_UnrarHeadertype.MarkHeader.equals(headerType)){
			return Inno_UnrarHeadertype.MarkHeader;
		}
		if(Inno_UnrarHeadertype.MainHeader.equals(headerType)){
			return Inno_UnrarHeadertype.MainHeader;
		}
		if(Inno_UnrarHeadertype.FileHeader.equals(headerType)){
			return Inno_UnrarHeadertype.FileHeader;
		}
		if(Inno_UnrarHeadertype.EndArcHeader.equals(headerType)){
			return Inno_UnrarHeadertype.EndArcHeader;
		}
		if(Inno_UnrarHeadertype.CommHeader.equals(headerType)){
			return Inno_UnrarHeadertype.CommHeader;
		}
		if(Inno_UnrarHeadertype.AvHeader.equals(headerType)){
			return Inno_UnrarHeadertype.AvHeader;
		}
		return null;
	}

	
	
	private byte headerByte;
	
	private Inno_UnrarHeadertype(byte headerByte)
	{
		this.headerByte = headerByte;
	}

	public boolean equals(byte header)
	{
		return headerByte == header;
	}

	public byte getHeaderByte() {
		return headerByte;
	}
}