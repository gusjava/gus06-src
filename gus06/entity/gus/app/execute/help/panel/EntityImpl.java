package gus06.entity.gus.app.execute.help.panel;

import gus06.framework.*;

public class EntityImpl implements Entity, I {

	public String creationDate() {return "20160919";}


	private Service viewer;
	private Service inside;
	
	
	
	public EntityImpl() throws Exception
	{
		viewer = Outside.service(this,"*gus.sys.helpviewer1.gui.maingui");
		inside = Outside.service(this,"gus.app.inside.help1");
		
		String help = (String) inside.r("main");
		viewer.p(help);
	}
	
	
	public Object i() throws Exception
	{return viewer.i();}
}
