package gus06.entity.gus.appli.gusclient1.execute.entity.remove;

import gus06.framework.*;

public class EntityImpl implements Entity, E {

	public String creationDate() {return "20140801";}


	private Service selection;
	private Service remove;
	private Service confirm;
	private Service isOwn;
	private Service listingCache;

	public EntityImpl() throws Exception
	{
		selection = Outside.service(this,"gus.appli.gusclient1.gui.entity.holder");
		remove = Outside.service(this,"gus.command.entity.remove");
		confirm = Outside.service(this,"gus.input.confirm.dialog");
		isOwn = Outside.service(this,"gus.app.entity.checkname.own");
		listingCache = Outside.service(this,"gus.entitydev.listing1.cache");
	}
	
	
	public void e() throws Exception
	{
		String name = (String) selection.g();
		if(name==null) return;
		if(!isOwn.f(name)) return;
		
		if(confirm.f("Removing entity "+name+" ?"))
		remove.p(name);
		listingCache.e();
	}
}
