package gus06.entity.gus.app.entity.checkname.gus;

import gus06.framework.*;

public class EntityImpl implements Entity, F {

	public String creationDate() {return "20140828";}


	private Service check;


	public EntityImpl() throws Exception
	{
		check = Outside.service(this,"gus.app.entity.checkname");
	}
	
	
	public boolean f(Object obj) throws Exception
	{
		String name = (String) obj;
		if(!check.f(name)) return false;
		
		return name.startsWith("gus.");
	}
}
