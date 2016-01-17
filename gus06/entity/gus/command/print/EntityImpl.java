package gus06.entity.gus.command.print;

import gus06.framework.*;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20140701";}

	
	private Service ruleToObject;
	private Service printObject;
	
	
	public EntityImpl() throws Exception
	{
		ruleToObject = Outside.service(this,"gus.command.ruletoobj");
		printObject = Outside.service(this,"gus.print.object");
	}


	public void p(Object obj) throws Exception
	{
		String rule = (String) obj;
		Object result = ruleToObject.t(rule);
		printObject.p(result);
	}	
}