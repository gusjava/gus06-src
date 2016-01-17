package gus06.manager.gus.gyem.m039.t.entity.class1.load.url;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;

import gus06.framework.*;
import gus06.manager.gus.gyem.GyemSystem;

public class Module extends GyemSystem implements T, R {
	
	
	public Object t(Object obj) throws Exception
	{
		String entityName = (String) obj;
		if(loadDisabled()) return mainURL();
		
		File jar = entityJarFile(entityName);
		if(jar!=null) return jar.toURI().toURL();
		
		return mainURL();
	}
	
	
	public Object r(String key) throws Exception
	{return t(key);}
	
	
	private boolean loadDisabled() throws Exception
	{return ((F) module(M013_F_PROP_BOOL_DF)).f(PROP_APPLOADDISABLED);}
	
	
	private File entityJarFile(String entityName) throws Exception
	{return (File) ((T) module(M040_T_ENTITY_JARFILE)).t(entityName);}
	
	
	private URL mainURL()
	{return Outside.class.getProtectionDomain().getCodeSource().getLocation();}
}