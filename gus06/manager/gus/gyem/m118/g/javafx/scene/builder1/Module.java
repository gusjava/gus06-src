package gus06.manager.gus.gyem.m118.g.javafx.scene.builder1;

import gus06.framework.*;
import gus06.manager.gus.gyem.GyemSystem;
import javafx.scene.Scene;
import javafx.scene.Parent;

public class Module extends GyemSystem implements G {

	public Object g() throws Exception
	{
		Object obj = ((T) module(M103_T_GENERATOR)).t(PROP_MAINGUI);
		return toScene(obj);
	}
	
	
	private Scene toScene(Object obj) throws Exception
	{
		if(obj==null) return null;
		if(obj instanceof Scene) return (Scene) obj;
		if(obj instanceof Parent) return new Scene((Parent) obj);
		if(obj instanceof I) return toScene(((I) obj).i());
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
}