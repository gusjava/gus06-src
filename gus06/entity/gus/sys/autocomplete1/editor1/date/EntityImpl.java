package gus06.entity.gus.sys.autocomplete1.editor1.date;

import gus06.framework.*;
import javax.swing.text.JTextComponent;
import java.awt.Color;
import javax.swing.JColorChooser;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20160622";}
	
	public static final String REGEX_HTML_COLOR = "#[0-9a-fA-F]{6}";
	public static final String REGEX_JAVA_COLOR = "(Color\\.[A-Z_]+)|(new Color\\([^\\)]+\\))";


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
		
		if(text.matches(REGEX_HTML_COLOR))
		{
			Color c = chooseColor(text);
			if(c!=null) replace(comp,colorToHtml,c);
		}
		else if(text.matches(REGEX_JAVA_COLOR))
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
