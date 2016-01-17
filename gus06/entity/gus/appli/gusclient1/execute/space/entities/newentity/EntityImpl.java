package gus06.entity.gus.appli.gusclient1.execute.space.entities.newentity;

import gus06.framework.*;

public class EntityImpl implements Entity, E {

	public String creationDate() {return "20140812";}

	private Service generate;
	private Service input;
	private Service listingCache;

	
	public EntityImpl() throws Exception
	{
		generate = Outside.service(this,"gus.command.entity.generate");
		input = Outside.service(this,"gus.input.text.dialog");
		listingCache = Outside.service(this,"gus.entitydev.listing1.cache");
	}
	
	public void e() throws Exception
	{
		String name = (String) input.t("Enter new name");
		if(name==null) return;
		
		generate.p(name);
		listingCache.e();
	}
}
