package gus06.manager.gus.gyem;

import gus06.framework.E;
import gus06.framework.Outside;
import gus06.manager.gus.gyem.tools.SupportMap;

import java.lang.reflect.Field;
import java.util.Date;

public class GyemMain extends GyemSystem {

	public static void main(String[] args)
	{
		startTime = new Date();
		appArgs = args;
		
		m = new SupportMap(MAPNAME_MAIN);
		
		put(KEY_APPARGS,appArgs);
		put(KEY_STARTTIME,startTime);
		put(KEY_MANAGERID,VERSION.ID);
		put(KEY_MANAGERBUILD,VERSION.BUILD);
		
		try
		{
			Field[] fs = GyemConst.class.getDeclaredFields();
			for(Field f:fs) if(f.getType().equals(Class.class))
			initModule((Class) f.get(null));
			
			Outside.setManager(new GyemManager());
			
			((E) module(M001_E_CUSTOMIZER)).e();
			((E) module(M002_E_LAUNCHER)).e();
		}
		catch(Exception e)
		{fatal_main(e);}
	}
}