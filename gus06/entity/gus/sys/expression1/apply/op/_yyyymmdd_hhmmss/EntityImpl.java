package gus06.entity.gus.sys.expression1.apply.op._yyyymmdd_hhmmss;

import gus06.framework.*;
import java.util.Date;
import java.text.SimpleDateFormat;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151110";}
	
	private SimpleDateFormat yyyyMMdd_HHmmss = new SimpleDateFormat("yyyyMMdd_HHmmss");
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return null;
		if(obj instanceof Date) return yyyyMMdd_HHmmss((Date) obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	private String yyyyMMdd_HHmmss(Date date)
	{return yyyyMMdd_HHmmss.format(date);}
}
