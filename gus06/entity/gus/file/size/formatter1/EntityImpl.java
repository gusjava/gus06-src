package gus06.entity.gus.file.size.formatter1;

import gus06.framework.*;
import java.text.NumberFormat;
import java.io.File;


public class EntityImpl implements Entity, T {

	public String creationDate() {return "20140910";}


	public static NumberFormat nf = NumberFormat.getInstance();
	
	public static final long Go = 1000000000L;
	public static final long Mo = 1000000L;
	public static final long Ko = 1000L;
	
	
	

	public Object t(Object obj) throws Exception
	{
		long size = toLong(obj);
		if(size >= Go) return formatSize_Go(size);
		if(size >= Mo) return formatSize_Mo(size);
		if(size >= Ko) return formatSize_Ko(size);
		return formatSize_o(size);
	}
	
	
	private long toLong(Object obj) throws Exception
	{
		if(obj instanceof Long) return ((Long) obj).longValue();
		if(obj instanceof String) return Long.parseLong((String) obj);
		if(obj instanceof File) return ((File) obj).length();
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	


	
	private String formatSize_Go(long size)
	{
		long sizeGo = size/Go;
		String sizeGo_ = nf.format(sizeGo);
		if(sizeGo>=10) return sizeGo_+" Go";
		
		int round = (int) ((size-sizeGo*Go)/(Mo*100));
		if(round==0) return sizeGo_+" Go";
		return sizeGo_+","+round+" Go";
	}
	
	
	
	private String formatSize_Mo(long size)
	{
		long sizeMo = size/Mo;
		String sizeMo_ = nf.format(sizeMo);
		if(sizeMo>=10) return sizeMo_+" Mo";
		
		int round = (int) ((size-sizeMo*Mo)/(Ko*100));
		if(round==0) return sizeMo_+"Mo";
		return sizeMo_+","+round+" Mo";
	}
	
	
	
	private String formatSize_Ko(long size)
	{
		long sizeKo = size/Ko;
		String sizeKo_ = nf.format(sizeKo);
		if(sizeKo>=10) return sizeKo_+" Ko";
		
		int round = (int) ((size-sizeKo*Ko)/100);
		if(round==0) return sizeKo_+"Ko";
		return sizeKo_+","+round+" Ko";
	}
	
	
	
	
	private String formatSize_o(long size)
	{
		return nf.format(size)+" octets";
	}
}
