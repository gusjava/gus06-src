package gus06.manager.gus.gyem.m002.e.launcher;

import gus06.framework.*;
import gus06.manager.gus.gyem.GyemSystem;
import java.util.Map;

public class Module extends GyemSystem implements E {

	
	public void e() throws Exception
	{
		((E) module(M003_E_START)).e();
		
		String type = getType();

		if(type.equals(TYPE_NOGUI))	{((E) module(M112_E_TYPE_NOGUI)).e();return;}
		if(type.equals(TYPE_SWING))	{((E) module(M113_E_TYPE_SWING)).e();return;}
		if(type.equals(TYPE_JAVAFX))	{((E) module(M114_E_TYPE_JAVAFX)).e();return;}
		
		throw new Exception("Unsupported application type: "+type);
	}
	
	
	private String getType() throws Exception
	{
		Map prop = (Map) ((G) module(M012_G_PROP)).g();
		if(prop==null || !prop.containsKey(PROP_TYPE)) return TYPE_DEFAULT;
		return (String) prop.get(PROP_TYPE);
	}

}