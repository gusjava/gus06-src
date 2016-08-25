package gus06.entity.gus.sys.expression1.apply.op._ifnull;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160630";}
	
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		return new T1(obj);
	}
	
	
	
	private class T1 implements T
	{
		private Object value;
		
		public T1(Object value)
		{this.value = value;}
		
		public Object t(Object obj) throws Exception
		{return new T2(value,obj);}
	}
	
	
	private class T2 implements T
	{
		private Object value;
		private Object data;
		
		public T2(Object value, Object data)
		{
			this.value = value;
			this.data = data;
		}
		
		public Object t(Object obj) throws Exception
		{return value==null ? data : obj;}
	}
}
