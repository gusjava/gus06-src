package gus06.entity.gus.app.mainframe.defaulttitle;

import gus06.framework.*;
import javax.swing.JFrame;

public class EntityImpl implements Entity, G {

	public String creationDate() {return "20140826";}


	private String title;
	private String version;
	
	

	public EntityImpl() throws Exception
	{
		title = (String) Outside.resource(this,"property#app.title");
		version = (String) Outside.resource(this,"property#app.version");
	}
	
	
	public Object g() throws Exception
	{return title+" "+version;}
}
