package gus06.entity.gus.sys.expression1.apply.op._next;

import gus06.framework.*;
import java.util.Iterator;
import java.io.File;
import java.util.Date;
import java.sql.ResultSet;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151110";}


	private Service perform;
	
	public EntityImpl() throws Exception
	{
		perform = Outside.service(this,"gus.data.perform.iterate.next");
	}

	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return null;
		
		if(obj instanceof String) return perform.t(obj);
		if(obj instanceof Integer) return perform.t(new Integer(""+obj));
		if(obj instanceof File) return perform.t(obj);
		if(obj instanceof Date) return perform.t(obj);
		
		if(obj instanceof G) return perform.t(obj);
		if(obj instanceof Iterator) return perform.t(obj);
		if(obj instanceof ResultSet) return perform.t(obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
}
