package gus06.entity.gus.app.jarmap.gui.viewer;

import gus06.framework.*;
import java.util.Map;

public class EntityImpl implements Entity, I {

	public String creationDate() {return "20140808";}

	private Map map;
	private Service viewer;

	
	public EntityImpl() throws Exception
	{
		map = (Map) Outside.resource(this,"jarmap");
		viewer = Outside.service(this,"*gus.data.viewer.map");
		viewer.p(map);
	}
	
	
	public Object i() throws Exception
	{return viewer.i();}
}
