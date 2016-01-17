package gus06.manager.gus.gyem.m116.p.javafx.stage.customizer;

import gus06.framework.*;
import gus06.manager.gus.gyem.GyemSystem;
import java.util.Map;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class Module extends GyemSystem implements P {
	
	public void p(Object obj) throws Exception
	{
		Stage stage = (Stage) obj;
		
		Map prop = (Map) ((G) module(M012_G_PROP)).g();
		
		String title = get(prop,PROP_APPTITLE,DEFAULT_APPTITLE);
		String size = get(prop,PROP_APPSIZE,DEFAULT_APPSIZE);
		String style = get(prop,PROP_APPSTYLE,null);
		
		String[] n = size.split(" ");
		int width = i_(n[0]);
		int height = i_(n[1]);
		
		stage.setWidth(width);
		stage.setHeight(height);
		stage.setTitle(title);
		
		StageStyle stageStyle = getStyle(style);
		if(stageStyle!=null) stage.initStyle(stageStyle);
	}
	
	
	
	private String get(Map prop, String key, String defaultValue)
	{
		if(!prop.containsKey(key)) return defaultValue;
		return (String) prop.get(key);
	}



	private int i_(String s)
	{return Integer.parseInt(s);}
	
	
	
	
	private StageStyle getStyle(String style) throws Exception
	{
		if(style==null) return null;
		String s = style.toUpperCase();
		
		if(s.equals("DECORATED")) return StageStyle.DECORATED;
		if(s.equals("UNDECORATED")) return StageStyle.UNDECORATED;
		if(s.equals("TRANSPARENT")) return StageStyle.TRANSPARENT;
		if(s.equals("UNIFIED")) return StageStyle.UNIFIED;
		if(s.equals("UTILITY")) return StageStyle.UTILITY;
		
		throw new Exception("Invalid app style value: "+style);
	}
}