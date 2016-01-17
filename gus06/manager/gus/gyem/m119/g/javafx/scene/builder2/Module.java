package gus06.manager.gus.gyem.m119.g.javafx.scene.builder2;

import java.awt.Color;

import gus06.framework.T;
import gus06.manager.gus.gyem.GyemSystem;
import gus06.manager.gus.gyem.tools.Tool_Throwable;

import javafx.scene.control.TextArea;
import javafx.scene.control.ScrollPane;
import javafx.scene.Scene;
import javafx.scene.layout.Region;


public class Module extends GyemSystem implements T {
	
	private String css_foreground = "-fx-text-inner-color: red;";
	private String css_background= "-fx-control-inner-background: black;";
	private String css_font = "-fx-font-size: 14px;";


	public Object t(Object obj) throws Exception
	{
		Exception ex = (Exception) obj;
		String s = Tool_Throwable.description(ex);
		
		TextArea area = new TextArea(s);
		area.setEditable(false);
		area.setStyle(css_font+css_foreground+css_background);
		
		return new Scene(area);
	}
}