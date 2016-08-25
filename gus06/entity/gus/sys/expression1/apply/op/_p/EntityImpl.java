package gus06.entity.gus.sys.expression1.apply.op._p;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160413";}
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return null;
		if(obj instanceof P) return new T1((P) obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	
	
	private class T1 implements T
	{
		private P p;
		public T1(P p){this.p = p;}
		
		public Object t(Object obj) throws Exception
		{return new E1(p,obj);}
	}
	
	
	private class E1 implements E
	{
		private P p;
		private Object obj;
		
		public E1(P p, Object obj)
		{
			this.p = p;
			this.obj = obj;
		}
		
		public void e() throws Exception
		{p.p(obj);}
	}
}