package gus06.manager.gus.gyem.m034.t.entity.class1.load;

import gus06.framework.T;
import gus06.framework.R;
import gus06.manager.gus.gyem.GyemSystem;

public class Module extends GyemSystem implements T, R {

	public Object t(Object obj) throws Exception
	{
		String entityName = (String) obj;
		ClassLoader cl = findClassLoader(entityName);
		String classPath = nameToPath(entityName);
		return Class.forName(classPath,true,cl);
	}
	
	public Object r(String key) throws Exception
	{return t(key);}
	
	
	
	
	private ClassLoader findClassLoader(String entityName) throws Exception
	{return (ClassLoader) ((T) module(M035_T_ENTITY_CLASS1_LOAD_CL)).t(entityName);}
	
	
	private String nameToPath(String entityName) throws Exception
	{return (String) ((T) module(M043_T_ENTITY_NAMETOPATH)).t(entityName);}
}