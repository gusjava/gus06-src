package gus06.entity.gus.app.jarfile.extract1.manager2;

import gus06.framework.*;

public class EntityImpl implements Entity, E {

	public String creationDate() {return "20140908";}


	private Service extract;
	private Service check;
	private Service clear;
	
	
	public EntityImpl() throws Exception
	{
		extract = Outside.service(this,"gus.app.jarfile.extract1.manager");
		check = Outside.service(this,"gus.app.jarfile.extract1.manager2.check");
		clear = Outside.service(this,"gus.app.jarfile.extract1.manager2.clear");
	}
	
	
	public void e() throws Exception
	{
		if(!check.f(null)) return;
		
		clear.e();
		extract.e();
	}
}
