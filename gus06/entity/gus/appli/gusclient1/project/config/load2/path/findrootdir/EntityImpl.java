package gus06.entity.gus.appli.gusclient1.project.config.load2.path.findrootdir;

import gus06.framework.*;
import java.util.Map;

public class EntityImpl implements Entity, G {

	public String creationDate() {return "20150312";}

	public static final String PATH_ROOTDIR = "path.rootdir";
	
	
	private Service loadPath;


	public EntityImpl() throws Exception
	{
		loadPath = Outside.service(this,"gus.appli.gusclient1.project.config.load2.path");
	}
	
	
	public Object g() throws Exception
	{
		Map paths = (Map) loadPath.g();
		if(!paths.containsKey(PATH_ROOTDIR)) return null;
		return paths.get(PATH_ROOTDIR);
	}
}
