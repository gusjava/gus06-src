package gus06.entity.gus.sys.expression1.apply.op._startdate_app;

import gus06.framework.*;
import java.util.Date;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20170329";}

	public static final String T = "constant";
	

	private Date date;
		
	public EntityImpl() throws Exception
	{
		date = (Date) Outside.resource(this,"main.starttime");
	}

	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		return date;
	}
}
