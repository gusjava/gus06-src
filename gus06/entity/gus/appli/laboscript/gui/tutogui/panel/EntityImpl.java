package gus06.entity.gus.appli.laboscript.gui.tutogui.panel;

import gus06.framework.*;

public class EntityImpl extends S1 implements Entity, I, P {

	public String creationDate() {return "20160701";}


	private Service editor;
	
	public EntityImpl() throws Exception
	{
		editor = Outside.service(this,"*gus.file.editor.ext.gus");
	}
	
	
	public Object i() throws Exception
	{
		return null;
	}
	
	
	public void p(Object obj) throws Exception
	{
		
	}
}