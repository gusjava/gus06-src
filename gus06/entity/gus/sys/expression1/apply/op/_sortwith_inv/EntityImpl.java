package gus06.entity.gus.sys.expression1.apply.op._sortwith_inv;

import gus06.framework.*;
import java.util.Map;
import java.util.List;
import java.util.Set;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20170501";}


	private Service builder;
	private Service perform;
	private Service findList;
	
	
	public EntityImpl() throws Exception
	{
		builder = Outside.service(this,"gus.sys.expression1.builder2.t");
		perform = Outside.service(this,"gus.data.perform.sortwith.inv");
		findList = Outside.service(this,"gus.find.list");
	}

	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		Object value = o[0];
		Map opMap = (Map) o[1];
		
		if(value==null) return null;
		
		if(value instanceof List) return new T1(value,opMap);
		
		if(value instanceof Set) return new T1(findList.t(value),opMap);
		if(value instanceof Object[]) return new T1(findList.t(value),opMap);
		if(obj instanceof int[]) return new T1(findList.t(value),opMap);
		if(obj instanceof short[]) return new T1(findList.t(value),opMap);
		if(obj instanceof long[]) return new T1(findList.t(value),opMap);
		if(obj instanceof double[]) return new T1(findList.t(value),opMap);
		if(obj instanceof float[]) return new T1(findList.t(value),opMap);
		if(obj instanceof boolean[]) return new T1(findList.t(value),opMap);
		if(obj instanceof char[]) return new T1(findList.t(value),opMap);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
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
		{return perform.t(new Object[]{value,toT(obj)});}
		
		private T toT(Object obj) throws Exception
		{return (T) builder.t(new Object[]{obj,opMap});}
	}
}
