package gus06.manager.gus.gyem.m117.g.javafx.scene.builder;

import gus06.framework.*;
import gus06.manager.gus.gyem.GyemSystem;
import javafx.scene.Scene;

public class Module extends GyemSystem implements G {
	
	private Scene scene;
	
	public Object g() throws Exception
	{
		if(scene==null) init();
		return scene;
	}
	
	
	
	private void init() throws Exception
	{
		try
		{
			scene = (Scene) ((G) module(M118_G_JAVAFX_SCENE_BUILDER1)).g();
			if(scene==null) scene = (Scene) ((G) module(M120_G_JAVAFX_SCENE_DEFAULTGUI)).g();
		}
		catch(Exception ex)
		{
			scene = (Scene) ((T) module(M119_G_JAVAFX_SCENE_BUILDER2)).t(ex);
		}
	}
}