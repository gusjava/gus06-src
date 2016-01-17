package gus06.entity.gus.app.prop.gui.viewer;

import gus06.framework.*;
import java.util.Map;

public class EntityImpl implements Entity, I {

	public String creationDate() {return "20141022";}

	private Map prop;
	private Service viewer;

	
	public EntityImpl() throws Exception
	{
		prop = (Map) Outside.resource(this,"prop");
		viewer = Outside.service(this,"*gus.data.viewer.map.stringmap");
		viewer.p(prop);
	}
	
	
	public Object i() throws Exception
	{return viewer.i();}
}
