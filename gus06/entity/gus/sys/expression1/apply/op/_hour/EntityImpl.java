package gus06.entity.gus.sys.expression1.apply.op._hour;

import gus06.framework.*;
import java.util.Date;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160625";}


	private Service hour;
	private Service findDate;
	
	public EntityImpl() throws Exception
	{
		hour = Outside.service(this,"gus.time.date.get.hour");
		findDate = Outside.service(this,"gus.find.date");
	}

	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return null;
		
		if(obj instanceof Date) return hour(obj);
		if(obj instanceof Long) return hour(findDate.t(obj));
		if(obj instanceof int[]) return hour(findDate.t(obj));
		if(obj instanceof String) return hour(findDate.t(obj));
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	private Object hour(Object obj) throws Exception
	{return hour.t(obj);}
}
