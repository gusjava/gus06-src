package gus06.entity.gus.sys.expression1.apply.op._wrap_g;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151122";}

	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		return new Wrap(obj);
	}
	
	private class Wrap implements G
	{
		private Object data;
		public Wrap(Object data) {this.data = data;}
		
		public Object g() throws Exception
		{return data;}
	}
}
