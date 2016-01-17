package gus06.entity.gus.sys.expression1.apply.op._e_eachkey;

import gus06.framework.*;
import java.util.Map;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151125";}


	private Service builder;
	private Service perform;
	
	
	public EntityImpl() throws Exception
	{
		builder = Outside.service(this,"gus.sys.expression1.builder1.t");
		perform = Outside.service(this,"gus.map.key.each");
	}

	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		Object value = o[0];
		Map opMap = (Map) o[1];
		
		if(value==null) return null;
		
		if(value instanceof Map) return new T1(value,opMap);
		
		throw new Exception("Invalid data type: "+value.getClass().getName());
	}
	
	
	private class T1 implements T
	{
		private Object value;
		private Map opMap;
		
		public T1(Object value, Map opMap)
		{
			this.value = value;
			this.opMap = opMap;
		}
		
		public Object t(Object obj) throws Exception
		{
			T t = (T) builder.t(new Object[]{obj,opMap});
			return new E1(new Object[]{value,t});
		}
	}
	
	
	private class E1 implements E
	{
		private Object o;
		public E1(Object o){this.o = o;}
		
		public void e() throws Exception
		{perform.p(o);}
	}
}
