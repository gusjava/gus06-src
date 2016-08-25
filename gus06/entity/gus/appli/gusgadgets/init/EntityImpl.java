package gus06.entity.gus.appli.gusgadgets.init;

import gus06.framework.*;

public class EntityImpl implements Entity {

	public String creationDate() {return "20160605";}


	private Service manager;

	public EntityImpl() throws Exception
	{
		manager = Outside.service(this,"gus.appli.gusgadgets.manager");
		
		init(Outside.service(this,"gus.appli.gusgadgets.item.demo3d"));
		init(Outside.service(this,"gus.appli.gusgadgets.item.clock1"));
		init(Outside.service(this,"gus.appli.gusgadgets.item.watcherkeyboard"));
		init(Outside.service(this,"gus.appli.gusgadgets.item.desktopviewer"));
	}
	
	private void init(Service s) throws Exception
	{manager.p(s);}
}
