package gus06.entity.gus.file.rar.innosystec.unrar;

public class Inno_BitInput {
	
	public static final int MAX_SIZE = 0x8000;
	protected int inAddr;
	protected int inBit;
	protected byte[] inBuf;
	
	public void InitBitInput()
	{
		inAddr=0;
		inBit=0;
	}
	
	public void addbits(int Bits)
	{
		Bits+=inBit;
		inAddr+=Bits>>3;
		inBit=Bits&7;
	}
	
	public int getbits()
	{
//		int BitField=0;
//		BitField|=(int)(inBuf[inAddr] << 16)&0xFF0000;
//		BitField|=(int)(inBuf[inAddr+1] << 8)&0xff00;
//		BitField|=(int)(inBuf[inAddr+2])&0xFF;
//		BitField >>>= (8-inBit);
//		return (BitField & 0xffff);
		return (((((inBuf[inAddr] & 0xff) << 16) +
				((inBuf[inAddr+1] & 0xff) << 8) +
				((inBuf[inAddr+2] & 0xff))) >>> (8-inBit)) & 0xffff);
	}


	public Inno_BitInput()
	{inBuf=new byte[MAX_SIZE];}

	public void faddbits(int Bits)
	{addbits(Bits);}
	
	public int fgetbits()
	{return(getbits());}
	
	public boolean Overflow(int IncPtr) {return(inAddr+IncPtr>=MAX_SIZE);}
	
	public byte[] getInBuf() {return inBuf;}
}