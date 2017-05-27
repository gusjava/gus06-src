package gus06.entity.gus.sys.expression1.apply.op._duration_s_script;

import gus06.framework.*;
import java.util.Map;
import java.util.Date;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20170329";}

	public static final String T = "constant";


	private Service duration;
	private Service findDate;
	private Service findContext;
		
	public EntityImpl() throws Exception
	{
		duration = Outside.service(this,"gus.time.duration.s");
		findDate = Outside.service(this,"gus.sys.script1.access.context.startdate1");
		findContext = Outside.service(this,"gus.sys.script1.access.opmap.context");
	}

	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		Map opMap = (Map) o[1];
		Map context = (Map) findContext.t(opMap);
		Date date = (Date) findDate.t(context);
		
		return duration.t(date);
	}
}
