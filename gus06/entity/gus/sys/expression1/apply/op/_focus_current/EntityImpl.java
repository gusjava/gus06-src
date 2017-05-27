package gus06.entity.gus.sys.expression1.apply.op._focus_current;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20170314";}


	private Service find;

	public EntityImpl() throws Exception
	{
		find = Outside.service(this,"gus.awt.focus.focussupport");
	}

	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		return find.g();
	}
}
