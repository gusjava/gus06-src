package gus06.entity.gus.sys.expression1.apply.op._nempty;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151205";}


	private Service op;


	public EntityImpl() throws Exception
	{
		op = Outside.service(this,"gus.sys.expression1.apply.op._empty");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		Object r = op.t(obj);
		if(r==null) return null;
		
		boolean b = ((Boolean)r).booleanValue();
		return new Boolean(!b);
	}
}
