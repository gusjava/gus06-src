package gus06.entity.gus.sys.expression1.apply.op._month_ja;

import gus06.framework.*;
import java.util.Date;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160625";}


	private Service month;
	private Service findDate;
	
	public EntityImpl() throws Exception
	{
		month = Outside.service(this,"gus.time.date.month.ja");
		findDate = Outside.service(this,"gus.find.date");
	}

	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return null;
		
		if(obj instanceof Date) return month(obj);
		if(obj instanceof Long) return month(findDate.t(obj));
		if(obj instanceof int[]) return month(findDate.t(obj));
		if(obj instanceof String) return month(findDate.t(obj));
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	private Object month(Object obj) throws Exception
	{return month.t(obj);}
}
