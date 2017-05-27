package gus06.entity.gus.sys.expression1.apply.op._tocolor;

import gus06.framework.*;
import java.awt.Color;
import java.util.List;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160505";}


	private Service perform;
	private Service listToArray;
	
	public EntityImpl() throws Exception
	{
		perform = Outside.service(this,"gus.find.color");
		listToArray = Outside.service(this,"gus.convert.listtointarray.strict");
	}

	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return null;
		
		if(obj instanceof Color) return perform.t(obj);
		if(obj instanceof Integer) return perform.t(obj);
		if(obj instanceof String) return perform.t(obj);
		if(obj instanceof int[]) return perform.t(obj);
		if(obj instanceof List) return perform.t(toArray(obj));
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	
	private Object toArray(Object obj) throws Exception
	{
		Object r = listToArray.t(obj);
		if(r==null) throw new Exception("Invalid list: "+obj);
		return r;
	}
}
