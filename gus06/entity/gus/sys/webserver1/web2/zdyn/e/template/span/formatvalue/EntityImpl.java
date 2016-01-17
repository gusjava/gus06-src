package gus06.entity.gus.sys.webserver1.web2.zdyn.e.template.span.formatvalue;

import gus06.framework.*;
import java.util.Map;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20141003";}

	private Service formatter;


	public EntityImpl() throws Exception
	{formatter = Outside.service(this,"gus.sys.webserver1.web2.zdyn.e.format.formatter2");}
	
	
	public Object t(Object obj) throws Exception
	{
		Map span = (Map) obj;
		
		R mr = (R) span.get("main");
		Map args = (Map) span.get("args");
		Map vars = (Map) span.get("vars");
		String value = (String) span.get("value");
		
		return formatter.t(new Object[]{mr,value,args,vars});
	}
}
