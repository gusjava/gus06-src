package gus06.manager.gus.gyem.m010.g.inside.root;

import gus06.framework.E;
import gus06.framework.G;
import gus06.framework.P;
import gus06.manager.gus.gyem.GyemSystem;
import javax.swing.JFrame;
import java.util.Map;


public class Module extends GyemSystem implements G {

	
	public Object g() throws Exception
	{
		Map params = (Map) ((G) module(M008_G_PARAMS)).g();
		
		if(params.containsKey("inside"))
			return format((String) params.get("inside"));
		
		return ROOTPATH_RESOURCE;
	}
	
	
	
	
	private String format(String path) throws Exception
	{
		if(path.startsWith("/gus06/resource/")) return path;
		if(path.startsWith("/")) path = path.substring(1);
		return ROOTPATH_RESOURCE+path;
	}

}