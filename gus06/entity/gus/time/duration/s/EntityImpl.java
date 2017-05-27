package gus06.entity.gus.time.duration.s;

import gus06.framework.*;
import java.util.Date;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20170329";}
	
	public static final long FACTOR = 1000;

	
	
	public Object t(Object obj) throws Exception
	{
		if(obj instanceof Date) return toNow((Date) obj);
		if(obj instanceof Date[]) return between((Date[]) obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	
	private Long toNow(Date d)
	{
		long t1 = System.currentTimeMillis();
		long dt = t1-d.getTime();
		return new Long(dt/FACTOR);
	}
	
	
	private Long between(Date[] d) throws Exception
	{
		if(d.length==2) throw new Exception("Wrong data number: "+d.length);
		long t1 = d[0].getTime();
		long t2 = d[1].getTime();
		long dt = t1-t2;
		return new Long(dt/FACTOR);
	}
}
