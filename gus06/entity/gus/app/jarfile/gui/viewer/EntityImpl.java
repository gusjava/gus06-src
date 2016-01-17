package gus06.entity.gus.app.jarfile.gui.viewer;

import gus06.framework.*;

public class EntityImpl implements Entity, I {

	public String creationDate() {return "20140807";}

	private Service viewer;
	private Service appJar;

	
	public EntityImpl() throws Exception
	{
		viewer = Outside.service(this,"*gus.file.editor.ext.jar");
		appJar = Outside.service(this,"gus.app.jarfile");
		
		viewer.p(appJar.g());
	}
	
	
	public Object i() throws Exception
	{return viewer.i();}
}
