package gus06.manager.gus.gyem.m120.g.javafx.scene.defaultgui;

import gus06.framework.G;
import gus06.manager.gus.gyem.GyemSystem;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class Module extends GyemSystem implements G {

	
	private Scene scene;
	
	public Object g() throws Exception
	{
		if(scene==null) init();
		return scene;
	}
	
	
	private void init() throws Exception
	{
		String text = (String) ((G) module(M121_G_DEFAULTGUI_EMPTYTEXT)).g();
		
		Text msg = new Text(text);
		VBox root = new VBox();
		root.getChildren().add(msg);
		scene = new Scene(root);
	}
}