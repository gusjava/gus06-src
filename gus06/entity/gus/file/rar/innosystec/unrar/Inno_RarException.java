package gus06.entity.gus.file.rar.innosystec.unrar;

public class Inno_RarException extends Exception
{
	
	private RarExceptionType type;
	
	public Inno_RarException(Exception e){
		super(RarExceptionType.unkownError.name(),e);
		this.type = RarExceptionType.unkownError;
	}
	
	public Inno_RarException(Inno_RarException e)
	{
		
		super(e.getMessage(),e);
		this.type = e.getType();
	}
	
	public Inno_RarException(RarExceptionType type){
		super(type.name());
		this.type = type;
	}
	
	
	
	public enum RarExceptionType{
		notImplementedYet,
		crcError,
		notRarArchive,
		badRarArchive,
		unkownError,
		headerNotInArchive,
		wrongHeaderType,
		ioError,
		rarEncryptedException ;
	}



	public RarExceptionType getType()
	{
		return type;
	}

	public void setType(RarExceptionType type)
	{
		this.type = type;
	}
}