package gus06.manager.gus.gyem.m021.g.path.find.rootdir;

import java.io.File;
import java.util.Map;

import gus06.framework.G;
import gus06.framework.T;
import gus06.manager.gus.gyem.GyemSystem;
import gus06.manager.gus.gyem.tools.Tool_File;

public class Module extends GyemSystem implements G {

	public static final String ROOT = "root";
	
	private File rootDir;
	
	
	public Object g() throws Exception
	{
		if(rootDir==null) rootDir = guslink(init());
		return rootDir;
	}
	
	
	private File init() throws Exception
	{
		Map params = (Map) ((G) module(M008_G_PARAMS)).g();
		if(params.containsKey(ROOT))
			return Tool_File.newFileOS((String) params.get(ROOT));
		
		Map prop = (Map) ((G) module(M015_G_PROP_INSIDE)).g();
		if(prop.containsKey(ROOT))
			return Tool_File.newFileOS((String) prop.get(ROOT));
		
		return new File(".");
	}
	
	
	private File guslink(File f) throws Exception
	{return (File) ((T) module(M122_T_GUSLINK)).t(f);}
}