package gus06.entity.gus.sys.expression1.apply.op._flatten_tomap_upto;

import gus06.framework.*;
import java.util.List;
import java.util.Set;
import java.util.Map;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20161218";}

	private Service perform;
	
	public EntityImpl() throws Exception
	{
		perform = Outside.service(this,"gus.map.flatten.tomap.upto");
	}
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return null;
		if(obj instanceof Map) return new T1(obj);
		if(obj instanceof Set) return new T1(obj);
		if(obj instanceof List) return new T1(obj);
		if(obj instanceof Object[]) return new T1(obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	
	
	private class T1 implements T
	{
		private Object value;
		public T1(Object value) {this.value = value;}
		
		public Object t(Object obj) throws Exception
		{return perform.t(new Object[]{value,obj});}
	}
}
