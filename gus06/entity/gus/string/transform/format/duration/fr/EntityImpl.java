package gus06.entity.gus.string.transform.format.duration.fr;

import gus06.framework.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150920";}
	
	
	public static final long MIN = 60;
	public static final long HOUR = 3600;
	public static final long DAY = 86400;
	
	public static final String U_d = "J";
	public static final String U_h = "H";
	public static final String U_m = "min";
	public static final String U_s = "s";
	
	
	
	
	public Object t(Object obj) throws Exception
	{
		long duration = toLong(obj)/1000;
		
		StringBuffer b = new StringBuffer();
		
		int days = (int) (duration/DAY);
		if(days>0) b.append(days+U_d+" ");
		duration = duration%DAY;
		
		int hours = (int) (duration/HOUR);
		if(hours>0) b.append(hours+U_h+" ");
		duration = duration%HOUR;
		
		int min = (int) (duration/MIN);
		if(min>0) b.append(min+U_m+" ");
		duration = duration%MIN;
		
		int sec = (int) duration;
		if(sec>0) b.append(sec+U_s+" ");
		
		if(b.length()==0) return "0"+U_s;
		
		b.deleteCharAt(b.length()-1);
		return b.toString();
	}
	
	
	
	private long toLong(Object obj) throws Exception
	{
		if(obj instanceof Long) return ((Long) obj).longValue();
		if(obj instanceof String) return Long.parseLong((String) obj);
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
}
