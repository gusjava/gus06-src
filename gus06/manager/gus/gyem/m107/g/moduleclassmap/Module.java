package gus06.manager.gus.gyem.m107.g.moduleclassmap;

import java.util.HashMap;
import java.util.Iterator;
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
		for(Field f:fs) if(f.getType().equals(Class.class))
		{
			String name = f.getName();
			Class value = (Class) f.get(null);
			map.put(name,value);
		}
	}	
}