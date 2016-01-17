package gus06.entity.gus.find.date;

import gus06.framework.*;
import java.util.Date;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20141106";}


	private Service stringToDate;

	public EntityImpl() throws Exception
	{stringToDate = Outside.service(this,"gus.convert.stringtodate");}
	
	
	
	public Object t(Object obj) throws Exception
	{
		if(obj==null) return null;
		if(obj instanceof Date) return obj;
		if(obj instanceof Long) return longToDate((Long) obj);
		if(obj instanceof String) return stringToDate((String) obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
		
	private Date longToDate(Long l)
	{return new Date(l.longValue());}
	
	
	private Date stringToDate(String s) throws Exception
	{return (Date) stringToDate.t(s);}
}
