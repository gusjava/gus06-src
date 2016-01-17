package gus06.entity.gus.appli.gusclient1.template.find;

import gus06.framework.*;

public class EntityImpl implements Entity, R {

	public String creationDate() {return "20140905";}


	private Service inside;
	private Service manager;


	public EntityImpl() throws Exception
	{
		inside = Outside.service(this,"gus.app.inside.template");
		manager = Outside.service(this,"gus.appli.gusclient1.template.manager");
	}
	
	
	public Object r(String key) throws Exception
	{
		String template = (String) manager.r(key);
		if(template!=null) return template;
		return inside.r(key);
	}
}
