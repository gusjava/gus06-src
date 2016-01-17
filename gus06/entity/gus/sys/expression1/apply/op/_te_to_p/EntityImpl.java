package gus06.entity.gus.sys.expression1.apply.op._te_to_p;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151205";}

	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		Object value = o[0];
		
		if(value==null) return null;
		if(value instanceof T) return new P1((T) value);
		
		throw new Exception("Invalid data type: "+value.getClass().getName());
	}
	
	
	private class P1 implements P
	{
		private T t;
		public P1(T t) {this.t = t;}
		
		public void p(Object obj) throws Exception
		{
			E e = (E) t.t(obj);
			e.e();
		}
	}
}
