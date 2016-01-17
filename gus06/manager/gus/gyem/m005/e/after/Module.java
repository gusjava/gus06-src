package gus06.manager.gus.gyem.m005.e.after;

import java.util.Map;
import gus06.framework.E;
import gus06.framework.F;
import gus06.manager.gus.gyem.GyemSystem;

public class Module extends GyemSystem implements E {

	public static final String KEY = "after";

	public void e() throws Exception
	{
		if(perform(KEY)) return;
		int index = 0;
		while(perform(KEY+"."+index)) index++;
	}
	
	private boolean perform(String key) throws Exception
	{return ((F) module(M103_T_GENERATOR)).f(key);}
}