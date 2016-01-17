package gus06.entity.gus.app.jarfile.listing.java.manager.gyem.modules;

import gus06.framework.*;

public class EntityImpl implements Entity, G {

	public String creationDate() {return "20140916";}


	private Service findList;
	
	public EntityImpl() throws Exception
	{findList = Outside.service(this,"gus.app.jarfile.listing.java.manager.gyem.groups");}
	
	public Object g() throws Exception
	{return findList.r("modules");}
}
