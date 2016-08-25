package gus06.entity.gus.sys.expression1.apply.op._formatdate_medium_en;

import gus06.framework.*;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160809";}
	
	public static final DateFormat DATEFORMAT = DateFormat.getDateInstance(DateFormat.MEDIUM,Locale.ENGLISH);
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return null;
		if(obj instanceof Date) return format((Date) obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	private String format(Date date)
	{return DATEFORMAT.format(date);}
}
