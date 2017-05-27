package gus06.entity.gus.sys.expression1.apply.op._wrap_key;

import gus06.framework.*;
import java.util.ArrayList;
import java.util.Map;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20161215";}


	private Service perform;
	
	
	public EntityImpl() throws Exception
	{
		perform = Outside.service(this,"gus.map.wrap.key");
	}



	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return null;
		
		if(obj instanceof Map) return new T1((Map) obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	
	private class T1 implements T
	{
		private Map map;
		
		public T1(Map map)
		{this.map = map;}
		
		public Object t(Object obj) throws Exception
		{return perform.t(new Object[]{map,obj});}
	}
	
	
}
