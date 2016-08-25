package gus06.entity.gus.sys.expression1.apply.op._operator_id;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160220";}


	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		return new Operator();
	}
	
	
	private class Operator implements T
	{
		public Object t(Object obj) throws Exception
		{
			Object[] o = (Object[]) obj;
			if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
			
			return o[0];
		}
	}
}
