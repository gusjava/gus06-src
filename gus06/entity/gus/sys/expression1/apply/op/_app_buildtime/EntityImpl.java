package gus06.entity.gus.sys.expression1.apply.op._app_buildtime;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160808";}

	public static final String T = "constant";
	

	private Service find;
		
	public EntityImpl() throws Exception
	{
		find = Outside.service(this,"gus.app.info.buildtime");
	}

	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		return find.g();
	}
}
