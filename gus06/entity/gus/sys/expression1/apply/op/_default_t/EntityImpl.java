package gus06.entity.gus.sys.expression1.apply.op._default_t;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160227";}
	
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return null;
		if(obj instanceof T) return new Wrap((T) obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	
	private class Wrap implements T
	{
		private T t;

		public Wrap(T t)
		{this.t = t;}
		
		public Object t(Object obj) throws Exception
		{return new T1(t,obj);}
	}
	
	
	private class T1 implements T
	{
		private T t;
		private Object d;
		
		public T1(T t, Object d)
		{
			this.t = t;
			this.d = d;
		}
		public Object t(Object obj) throws Exception
		{
			Object res = t.t(obj);
			return res!=null ? res : d;
		}
	}
}
