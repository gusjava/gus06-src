package gus06.manager.gus.gyem;

import gus06.framework.*;
import java.util.Map;

public class GyemAPI extends GyemSystem {
	
	
	public static Object accessUnique(String name) throws Exception
	{
		init();
		return ((T) module(M026_T_ENTITY_UNIQUE)).t(name);
	}
	
	public static Object accessNew(String name) throws Exception
	{
		init();
		return ((T) module(M028_T_ENTITY_GENERATOR)).t(name);
	}
	
	
	
	public static void init() throws Exception
	{
		if(apiMode) return;
		apiMode = true;
		
		initMain(new String[]{});
		initModules();
		initManager();
		
		((E) module(M001_E_CUSTOMIZER)).e();
	}
	
	
	public static Map getMap()
	{return m;}
}