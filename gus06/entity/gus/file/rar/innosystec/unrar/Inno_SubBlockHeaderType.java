package gus06.entity.gus.file.rar.innosystec.unrar;

public enum Inno_SubBlockHeaderType 
{
	EA_HEAD 	((short)0x100),
	UO_HEAD 	((short)0x101),
	MAC_HEAD 	((short)0x102),
	BEEA_HEAD 	((short)0x103),
	NTACL_HEAD 	((short)0x104),
	STREAM_HEAD	((short)0x105);
	
	private short subblocktype;

	private Inno_SubBlockHeaderType(short subblocktype)
	{this.subblocktype = subblocktype;}
	
	public boolean equals(short subblocktype)
	{return this.subblocktype == subblocktype;}
	
	public short getSubblocktype()
	{return subblocktype;}

	public static Inno_SubBlockHeaderType findSubblockHeaderType(short subType)
	{
		if(EA_HEAD.equals(subType))return EA_HEAD;
		if(UO_HEAD.equals(subType))return UO_HEAD;
		if(MAC_HEAD.equals(subType))return MAC_HEAD;
		if(BEEA_HEAD.equals(subType))return BEEA_HEAD;
		if(NTACL_HEAD.equals(subType))return NTACL_HEAD;
		if(STREAM_HEAD.equals(subType))return STREAM_HEAD;
		
		return null;
	}
}