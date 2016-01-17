package gus06.entity.gus.appli.gusclient1.project.config.load2.prop;

import gus06.framework.*;

public class EntityImpl implements Entity, G {

	public String creationDate() {return "20150311";}

	public static final String FILENAME = "prop";
	
	private Service loadConfig;


	public EntityImpl() throws Exception
	{loadConfig = Outside.service(this,"gus.appli.gusclient1.project.config.load2");}
	
	
	public Object g() throws Exception
	{return loadConfig.r(FILENAME);}
}
