package gus06.entity.gus.app.main.gui.viewer;

import gus06.framework.*;
import java.util.Map;

public class EntityImpl implements Entity, I {

	public String creationDate() {return "20140731";}

	private Map main;
	private Service viewer;

	
	public EntityImpl() throws Exception
	{
		main = (Map) Outside.resource(this,"main");
		viewer = Outside.service(this,"*gus.data.viewer.map");
		viewer.p(main);
	}
	
	
	public Object i() throws Exception
	{return viewer.i();}
}
