package gus06.manager.gus.gyem.m106.g.constmap;

import java.util.HashMap;
import java.util.Map;
import java.lang.reflect.Field;

import gus06.framework.G;
import gus06.manager.gus.gyem.GyemSystem;
import gus06.manager.gus.gyem.GyemConst;

public class Module extends GyemSystem implements G {

	private Map map;
	
	public Object g() throws Exception
	{
		if(map==null) init();
		return map;
	}
	
	
	private void init() throws Exception
	{
		map = new HashMap();
		
		Field[] fs = GyemConst.class.getDeclaredFields();
		for(Field f:fs) if(f.getType().equals(String.class))
		{
			String name = f.getName();
			String value = (String) f.get(null);
			map.put(name,value);
		}
	}	
}