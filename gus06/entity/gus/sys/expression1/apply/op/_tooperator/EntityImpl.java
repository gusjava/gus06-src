package gus06.entity.gus.sys.expression1.apply.op._tooperator;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151205";}


	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return null;
		if(obj instanceof T) return new Operator((T) obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	
	private class Operator implements T
	{
		private T t;
		public Operator(T t) {this.t = t;}
		
		public Object t(Object obj) throws Exception
		{
			Object[] o = (Object[]) obj;
			if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
			
			return t.t(o[0]);
		}
	}
}
