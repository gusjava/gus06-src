package gus06.entity.gus.app.jarfile.extract1.manager2.check;

import gus06.framework.*;

public class EntityImpl implements Entity, F {

	public String creationDate() {return "20140906";}


	private Service findBuild;
	private String build_jar;
	
	
	public EntityImpl() throws Exception
	{
		findBuild = Outside.service(this,"gus.appdev.gyem.findbuild");
		build_jar = (String) Outside.resource(this,"main.managerbuild");
	}
	
	
	public boolean f(Object obj) throws Exception
	{
		String build1 = (String) findBuild.g();
		return build1==null || !build1.equals(build_jar);
	}
}
