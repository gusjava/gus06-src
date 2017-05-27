package gus06.entity.gus.sys.expression1.apply.op._duration_s_app;

import gus06.framework.*;
import java.util.Date;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20170329";}

	public static final String T = "constant";


	private Service duration;
	private Date date;
		
	public EntityImpl() throws Exception
	{
		duration = Outside.service(this,"gus.time.duration.s");
		date = (Date) Outside.resource(this,"main.starttime");
	}

	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		return duration.t(date);
	}
}
