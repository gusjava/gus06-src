package gus06.entity.gus.sys.autocomplete1.editor1.color;

import gus06.framework.*;
import javax.swing.text.JTextComponent;
import java.awt.Color;
import javax.swing.JColorChooser;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20160521";}
	
	public static final String REGEX_HTML1 = "#[0-9a-fA-F]{6}";
	public static final String REGEX_HTML2 = "#[0-9a-fA-F]{3}";
	
	public static final String REGEX_JAVA1 = "Color\\.[A-Z_]+";
	public static final String REGEX_JAVA2 = "new Color\\([^\\)]+\\)";


	private Service stringToColor;
	private Service colorToHtml;
	private Service colorToJava;

	
	public EntityImpl() throws Exception
	{
		stringToColor = Outside.service(this,"gus.convert.stringtocolor");
		colorToHtml = Outside.service(this,"gus.convert.colortostring.html");
		colorToJava = Outside.service(this,"gus.convert.colortostring.javacode");
	}

	
	public void p(Object obj) throws Exception
	{
		JTextComponent comp = (JTextComponent) obj;
		
		String text = comp.getSelectedText();
		if(text==null) return;
		
		if(text.matches(REGEX_HTML1))
		{
			Color c = chooseColor(text);
			if(c!=null) replace(comp,colorToHtml,c);
		}
		if(text.matches(REGEX_HTML2))
		{
			Color c = chooseColor(text);
			if(c!=null) replace(comp,colorToHtml,c);
		}
		else if(text.matches(REGEX_JAVA1))
		{
			Color c = chooseColor(text);
			if(c!=null) replace(comp,colorToJava,c);
		}
		else if(text.matches(REGEX_JAVA2))
		{
			Color c = chooseColor(text);
			if(c!=null) replace(comp,colorToJava,c);
		}
		
		Color c = chooseColor(text);
		if(c!=null) replace(comp,colorToJava,c);
	}
	
	
	
	private void replace(JTextComponent comp, T t, Color c) throws Exception
	{
		String text = (String) t.t(c);
		
		int start = comp.getSelectionStart();
		comp.replaceSelection(text);
		comp.select(start,start+text.length());
	}
	
	private Color chooseColor(String s) throws Exception
	{
		Color color = (Color) stringToColor.t(s);
		return JColorChooser.showDialog(null,"Choose color",color);
	}
}
