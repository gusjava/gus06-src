package gus06.entity.gus.app.path.gui.viewer;

import gus06.framework.*;
import java.util.Map;

public class EntityImpl implements Entity, I {

	public String creationDate() {return "20141022";}

	private Map path;
	private Service viewer;

	
	public EntityImpl() throws Exception
	{
		path = (Map) Outside.resource(this,"path");
		viewer = Outside.service(this,"*gus.data.viewer.map.filemap");
		viewer.p(path);
	}
	
	
	public Object i() throws Exception
	{return viewer.i();}
}
