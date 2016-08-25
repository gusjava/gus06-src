package gus06.entity.gus.time.date.is.tomorrow;

import gus06.framework.*;
import java.util.Date;
import java.text.SimpleDateFormat;

public class EntityImpl implements Entity, F {

	public String creationDate() {return "20160625";}

	
	public boolean f(Object obj) throws Exception
	{
		Date date = (Date) obj;
		
		String s = yyyyMMdd(date);
		String s0 = yyyyMMdd(tomorrow());
		
		return s.equals(s0);
	}
	
	
	private Date tomorrow()
	{return new Date(System.currentTimeMillis() + 86400000L);}
	
	
	
	private SimpleDateFormat yyyyMMdd = new SimpleDateFormat("yyyyMMdd");
	
	private String yyyyMMdd(Date date)
	{return yyyyMMdd.format(date);}
}
