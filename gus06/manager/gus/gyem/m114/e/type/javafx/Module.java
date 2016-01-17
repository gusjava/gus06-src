package gus06.manager.gus.gyem.m114.e.type.javafx;

import gus06.framework.*;
import gus06.manager.gus.gyem.GyemSystem;

import javafx.application.Application;
import javafx.stage.Stage;

public class Module extends GyemSystem implements E {
	
	private static P handler;
	
	public void e() throws Exception
	{
		handler = (P) module(M115_P_JAVAFX_STAGE_HANDLER);
		Application.launch(Module.App.class, new String[]{});
	}
	
	public static class App extends Application
	{
		public void start(Stage stage)
		{
			try{handler.p(stage);}
			catch(Exception e)
			{GyemSystem.fatal_javafx_start(e);}
		}
	}
}