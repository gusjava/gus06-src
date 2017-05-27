package gus06.entity.gus.sys.expression1.apply.op._is_wednesday;

import gus06.framework.*;
import java.util.Date;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160614";}
	
	
	private Service check;
	private Service findDate;
	
	public EntityImpl() throws Exception
	{
		check = Outside.service(this,"gus.time.date.is.d.wednesday");
		findDate = Outside.service(this,"gus.find.date");
	}

	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return Boolean.FALSE;
		
		if(obj instanceof Date) return check(obj);
		if(obj instanceof Long) return check(findDate.t(obj));
		if(obj instanceof int[]) return check(findDate.t(obj));
		if(obj instanceof String) return check(findDate.t(obj));
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	
	private Boolean check(Object obj) throws Exception
	{return new Boolean(check.f(obj));}
}
