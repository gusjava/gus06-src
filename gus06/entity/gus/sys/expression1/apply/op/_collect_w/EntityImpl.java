package gus06.entity.gus.sys.expression1.apply.op._collect_w;

import gus06.framework.*;
import java.util.List;
import java.util.Set;
import java.util.Map;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160819";}


	private Service builderT;
	private Service builderH;
	private Service builderF;
	
	private Service wrap_ft;
	private Service wrap_fh;
	
	private Service perform;
	
	
	public EntityImpl() throws Exception
	{
		builderT = Outside.service(this,"gus.sys.expression1.builder2.t");
		builderH = Outside.service(this,"gus.sys.expression1.builder2.h");
		builderF = Outside.service(this,"gus.sys.expression1.builder2.f");
		
		wrap_ft = Outside.service(this,"gus.feature.wrap.ft.t");
		wrap_fh = Outside.service(this,"gus.feature.wrap.fh.h");
		
		perform = Outside.service(this,"gus.data.perform.collect");
	}

	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		Object value = o[0];
		Map opMap = (Map) o[1];
		
		if(value==null) return null;
		
		if(value instanceof Map) return new T1t(value,opMap);
		if(value instanceof List) return new T1t(value,opMap);
		if(value instanceof Set) return new T1t(value,opMap);
		if(value instanceof Object[]) return new T1t(value,opMap);
		if(value instanceof String) return new T1t(value,opMap);
		
		if(value instanceof double[]) return new T1h(value,opMap);
		if(value instanceof float[]) return new T1h(value,opMap);
		if(value instanceof int[]) return new T1h(value,opMap);
		if(value instanceof long[]) return new T1h(value,opMap);
		
		throw new Exception("Invalid data type: "+value.getClass().getName());
	}
	
	
	
	private class T1t implements T
	{
		private Object value;
		private Map opMap;
		
		public T1t(Object value, Map opMap)
		{
			this.value = value;
			this.opMap = opMap;
		}
		
		public Object t(Object obj) throws Exception
		{
			T t = (T) builderT.t(new Object[]{obj,opMap});
			return new T2t(value,t,opMap);
		}
	}
	
	private class T2t implements T
	{
		private Object value;
		private T t;
		private Map opMap;
		
		public T2t(Object value, T t, Map opMap)
		{
			this.value = value;
			this.t = t;
			this.opMap = opMap;
		}
		
		public Object t(Object obj) throws Exception
		{
			F f = (F) builderF.t(new Object[]{obj,opMap});
			T t1 = (T) wrap_ft.t(new Object[]{f,t});
			return perform.t(new Object[]{value,t1});
		}
	}
	
	
	
	
	
	private class T1h implements T
	{
		private Object value;
		private Map opMap;
		
		public T1h(Object value, Map opMap)
		{
			this.value = value;
			this.opMap = opMap;
		}
		
		public Object t(Object obj) throws Exception
		{
			H h = (H) builderH.t(new Object[]{obj,opMap});
			return new T2h(value,h,opMap);
		}
	}
	
	private class T2h implements T
	{
		private Object value;
		private H h;
		private Map opMap;
		
		public T2h(Object value, H h, Map opMap)
		{
			this.value = value;
			this.h = h;
			this.opMap = opMap;
		}
		
		public Object t(Object obj) throws Exception
		{
			F f = (F) builderF.t(new Object[]{obj,opMap});
			H h1 = (H) wrap_fh.t(new Object[]{f,h});
			return perform.t(new Object[]{value,h1});
		}
	}
}
