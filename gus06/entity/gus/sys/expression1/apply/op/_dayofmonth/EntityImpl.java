package gus06.entity.gus.sys.expression1.apply.op._dayofmonth;

import gus06.framework.*;
import java.util.Date;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160616";}


	private Service perform;
	private Service findDate;
	
	public EntityImpl() throws Exception
	{
		perform = Outside.service(this,"gus.time.date.dayofmonth");
		findDate = Outside.service(this,"gus.find.date");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return null;
		
		if(obj instanceof Date) return perform(obj);
		if(obj instanceof Long) return perform(findDate.t(obj));
		if(obj instanceof int[]) return perform(findDate.t(obj));
		if(obj instanceof String) return perform(findDate.t(obj));
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	private Object perform(Object obj) throws Exception
	{return perform.t(obj);}
}
