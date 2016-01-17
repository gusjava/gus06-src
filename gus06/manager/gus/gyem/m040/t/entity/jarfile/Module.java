package gus06.manager.gus.gyem.m040.t.entity.jarfile;

import java.io.File;
import java.util.Map;

import gus06.framework.*;
import gus06.manager.gus.gyem.GyemSystem;


public class Module extends GyemSystem implements T, R {

	public Object t(Object obj) throws Exception
	{
		String entityName = (String) obj;
		
		Map map = jarMap();
		if(map.containsKey(entityName))
		return (File) map.get(entityName);
		
		File cacheJar = new File(cacheDir(),entityName+".jar");
		updateJar(cacheJar);
		if(!cacheJar.exists()) return null;
		
		map.put(entityName,cacheJar);
		return cacheJar;
	}
	
	
	public Object r(String key) throws Exception
	{return t(key);}
	
	
	
	
	private Map jarMap() throws Exception
	{return (Map) ((G) module(M041_G_ENTITY_JARFILE_MAP)).g();}
	
	private void updateJar(File f) throws Exception
	{((P) module(M042_P_ENTITY_JARFILE_UPDATECACHE)).p(f);}
	
	private File cacheDir() throws Exception
	{return (File) ((R) module(M102_R_FILEPROVIDER)).r(PATH_GYEM_JARCACHE);}
}