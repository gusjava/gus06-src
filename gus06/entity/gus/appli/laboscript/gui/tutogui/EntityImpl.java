package gus06.entity.gus.appli.laboscript.gui.tutogui;

import gus06.framework.*;

public class EntityImpl implements Entity, I {

	public String creationDate() {return "20160630";}
	
	public static final String KEY = "scriptgus";


	private Service gui;
	private Service panel;
	


	public EntityImpl() throws Exception
	{
		gui = Outside.service(this,"*gus.sys.tuto1.gui");
		panel = Outside.service(this,"*gus.appli.laboscript.gui.tutogui.panel");
		
		gui.v("load",KEY);
		gui.v("validator",panel);
	}
	
	
	public Object i() throws Exception
	{return gui.i();}
}
