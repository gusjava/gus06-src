package gus06.manager.gus.gyem;

import java.util.Date;
import java.lang.reflect.Field;
import gus06.framework.Outside;
import gus06.manager.gus.gyem.tools.SupportMap;

public class GyemSystem extends GyemConst {
	
	protected static boolean apiMode = false;

	protected static SupportMap m;
	protected static Date startTime;
	protected static String[] appArgs;
	
	
	
	
	protected static boolean has(String key)
	{return m.containsKey(key);}
	
	protected static Object get(String key)
	{return has(key)?m.get(key):null;}
    
	protected static void put(String key, Object obj)
	{m.put(key,obj);}
    
	protected static Object module(Class c)
	{return get(classToName(c));}
	
	
	
	
	
	
	
	protected static void initMain(String[] args) throws Exception
	{
		startTime = new Date();
		appArgs = args;
		
		m = new SupportMap(MAPNAME_MAIN);
		
		put(KEY_APPARGS,appArgs);
		put(KEY_STARTTIME,startTime);
		put(KEY_MANAGERID,VERSION.ID);
		put(KEY_MANAGERNAME,VERSION.NAME);
		put(KEY_MANAGERBUILD,VERSION.BUILD);
	}
	
	
	protected static void initModules() throws Exception
	{
		Field[] fs = GyemConst.class.getDeclaredFields();
		for(Field f:fs) if(f.getType().equals(Class.class))
		initModule((Class) f.get(null));
	}
	
	
	protected static void initManager()
	{
		Outside.setManager(new GyemManager());
	}
	
    
    
    
	
	private static void initModule(Class c) throws Exception
	{put(classToName(c),c.newInstance());}
	
    
	private static String classToName(Class c)
	{
		String n = c.getName();
		return n.substring(MODULECLASS_START.length(),n.length()-MODULECLASS_END.length());
	}
    
    
    
    
	protected static void fatal_main(Exception e)
	{new GyemFatal(e,1);}
    
	protected static void fatal_manager(Exception e)
	{new GyemFatal(e,2);}
    
	protected static void fatal_javafx_start(Exception e)
	{new GyemFatal(e,3);}
    
	protected static void fatal_javafx_after(Exception e)
	{new GyemFatal(e,4);}
}