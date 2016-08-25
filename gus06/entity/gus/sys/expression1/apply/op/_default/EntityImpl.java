package gus06.entity.gus.sys.expression1.apply.op._default;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151124";}
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		return new Wrap(obj);
	}
	
	
	private class Wrap implements T
	{
		private Object value;
		
		public Wrap(Object value)
		{this.value = value;}
		
		public Object t(Object obj) throws Exception
		{return value!=null ? value : obj;}
	}
}
