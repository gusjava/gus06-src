package gus06.entity.gus.file.rar.innosystec.unrar;

public class Inno_VMStandardFilterSignature {
	private int length;
	private int CRC;
	private Inno_VMStandardFilters type;

	public Inno_VMStandardFilterSignature(int length, int crc, Inno_VMStandardFilters type)
	{
		super();
		this.length = length;
		CRC = crc;
		this.type = type;
	}

	public int getCRC() {return CRC;}
	public void setCRC(int crc) {CRC = crc;}
	public int getLength() {return length;}
	public void setLength(int length) {this.length = length;}
	public Inno_VMStandardFilters getType() {return type;}
	public void setType(Inno_VMStandardFilters type) {this.type = type;}
}