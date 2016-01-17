package gus06.entity.gus.app.entitymap.gui.viewer;

import gus06.framework.*;
import java.util.Map;

public class EntityImpl implements Entity, I {

	public String creationDate() {return "20140804";}

	private Map entitymap;
	private Service viewer;

	
	public EntityImpl() throws Exception
	{
		entitymap = (Map) Outside.resource(this,"entitymap");
		viewer = Outside.service(this,"*gus.data.viewer.map");
		viewer.p(entitymap);
	}
	
	
	public Object i() throws Exception
	{return viewer.i();}
}
