package gus06.manager.gus.gyem.m115.p.javafx.stage.handler;

import gus06.framework.*;
import gus06.manager.gus.gyem.GyemSystem;

import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.application.Platform;


public class Module extends GyemSystem implements P, G {
	
	private Stage stage;
	
	public Object g() throws Exception
	{return stage;}
	
	
	
	public void p(Object obj) throws Exception
	{
		stage = (Stage) obj;
		
		((P) module(M116_P_JAVAFX_STAGE_CUSTOMIZER)).p(stage);
		
		Scene scene = (Scene) ((G) module(M117_G_JAVAFX_SCENE_BUILDER)).g();
		
		stage.setScene(scene);
		stage.show();
		
		Platform.runLater(new Runnable() {public void run() {after();}});
	}
	
	
	private void after()
	{
		try
		{
			((E) module(M005_E_AFTER)).e();
			((E) module(M006_E_STARTED)).e();
		}
		catch(Exception e)
		{fatal_javafx_after(e);}
	}
}