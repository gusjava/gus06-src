package gus06.manager.gus.gyem.m035.t.entity.class1.load.cl;

import gus06.framework.*;
import gus06.manager.gus.gyem.GyemSystem;
import java.net.URL;
import java.net.URLClassLoader;

public class Module extends GyemSystem implements T, R {

	public Object t(Object obj) throws Exception
	{
		String entityName = (String) obj;
		
		ClassLoader main = mainClassLoader();
		URL url = findClassURL(entityName);
		return new EntityClassLoader(new URL[]{url},main);
	}
	
	
	public Object r(String key) throws Exception
	{return t(key);}
	
	
	
	private ClassLoader mainClassLoader() throws Exception
	{return (ClassLoader) ((G) module(M036_T_ENTITY_CLASS1_LOAD_MAIN)).g();}
	
	private URL findClassURL(String entityName) throws Exception
	{return (URL) ((T) module(M039_T_ENTITY_CLASS1_LOAD_URL)).t(entityName);}
	
	
	
	
	
	
	
	private class EntityClassLoader extends URLClassLoader
	{
		public EntityClassLoader(URL[] urls, ClassLoader parent)
		{super(urls,parent);}
	
		protected Class loadClass(String name, boolean resolve) throws ClassNotFoundException
		{
			if(!name.startsWith("gus06.entity."))
				return super.loadClass(name,resolve);
			
			synchronized(getClassLoadingLock(name))
			{
				Class c = findLoadedClass(name);
				if(c!=null) return c;
			
				c = findClass(name);
				if(resolve) resolveClass(c);
				if(c!=null) return c;
			}
			return super.loadClass(name,resolve);
		}
	}	
}