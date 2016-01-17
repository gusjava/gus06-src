package gus06.manager.gus.gyem.m100.g.path;

import java.io.File;
import java.util.Map;

import gus06.framework.G;
import gus06.framework.T;
import gus06.manager.gus.gyem.GyemSystem;

public class Module extends GyemSystem implements G {

	private Map map;
	
	public Object g() throws Exception
	{
		if(map==null) init();
		return map;
	}
	
	
	private void init() throws Exception
	{
		map = (Map) ((T) module(M104_T_BUILD_MAP)).t(MAPNAME_PATH);
		
		Map m = (Map) ((G) module(M101_G_PATH_PREDEFINED)).g();
		if(m!=null) map.putAll(m);
		
		
		File root = (File) ((G) module(M021_G_PATH_FIND_ROOTDIR)).g();
		if(root!=null) map.put(PATH_ROOTDIR,root);
		
		File propFile = (File) ((G) module(M022_G_PATH_FIND_PROPFILE)).g();
		if(propFile!=null) map.put(PATH_APPPROPFILE,propFile);
		
		File mappingFile = (File) ((G) module(M023_G_PATH_FIND_MAPPINGFILE)).g();
		if(mappingFile!=null) map.put(PATH_APPMAPPINGFILE,mappingFile);
	}
}