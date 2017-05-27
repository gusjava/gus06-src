package gus06.entity.gus.sys.expression1.apply.op._collect;

import gus06.framework.*;
import java.util.Map;
import java.util.List;
import java.util.Set;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151114";}


	private Service builderT;
	private Service builderH;
	private Service perform;
	
	
	public EntityImpl() throws Exception
	{
		builderT = Outside.service(this,"gus.sys.expression1.builder2.t");
		builderH = Outside.service(this,"gus.sys.expression1.builder2.h");
		perform = Outside.service(this,"gus.data.perform.collect");
	}

	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		Object value = o[0];
		Map opMap = (Map) o[1];
		
		if(value==null) return null;
		
		if(value instanceof List) return new T1(value,opMap);
		if(value instanceof Set) return new T1(value,opMap);
		if(value instanceof Map) return new T1(value,opMap);
		if(value instanceof Object[]) return new T1(value,opMap);
		if(value instanceof String) return new T1(value,opMap);
		
		if(value instanceof double[]) return new T2(value,opMap);
		if(value instanceof float[]) return new T2(value,opMap);
		if(value instanceof int[]) return new T2(value,opMap);
		if(value instanceof long[]) return new T2(value,opMap);
		
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
			T t = (T) builderT.t(new Object[]{obj,opMap});
			return perform.t(new Object[]{value,t});
		}
	}
	
	
	private class T2 implements T
	{
		private Object value;
		private Map opMap;
		
		public T2(Object value, Map opMap)
		{
			this.value = value;
			this.opMap = opMap;
		}
		
		public Object t(Object obj) throws Exception
		{
			H h = (H) builderH.t(new Object[]{obj,opMap});
			return perform.t(new Object[]{value,h});
		}
	}
}
