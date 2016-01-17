package gus06.entity.gus.command.print.size;

import gus06.framework.*;
import java.io.PrintStream;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20140828";}

	
	private Service ruleToObject;
	private Service objToSize;
	private PrintStream out;
	
	
	public EntityImpl() throws Exception
	{
		ruleToObject = Outside.service(this,"gus.command.ruletoobj");
		objToSize = Outside.service(this,"gus.tostring.size");
		out = (PrintStream) Outside.resource(this,"sysout");
	}


	public void p(Object obj) throws Exception
	{
		String rule = (String) obj;
		Object result = ruleToObject.t(rule);
		String size = (String) objToSize.t(result);
		out.println(size);
	}	
}