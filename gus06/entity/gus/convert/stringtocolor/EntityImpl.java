package gus06.entity.gus.convert.stringtocolor;

import gus06.framework.*;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20140729";}


	public static final String H = "[0-9ABCDEF]";
    
	private Pattern p_int = Pattern.compile("[0-9]+");
	private Pattern p_html1 = Pattern.compile("#?"+H+H+H+H+H+H);
	private Pattern p_html2 = Pattern.compile("#?"+H+H+H);

	private Service htmlToColor;


	public EntityImpl() throws Exception
	{htmlToColor = Outside.service(this,"gus.convert.stringtocolor.html");}
	
	
	
	public Object t(Object obj) throws Exception
	{return stringToColor((String) obj);}
		
		
		
		
	private Color stringToColor(String s) throws Exception
	{
		if(s.equals("")) return null;
		s = s.toLowerCase();
        
		if(s.endsWith(".darker"))
		{
        			s = s.substring(0,s.length()-7);
        			return stringToColor(s).darker();
        		}
		if(s.endsWith(".brighter"))
		{
			s = s.substring(0,s.length()-9);
			return stringToColor(s).brighter();
		}
        
		if(s.equals("blue"))		return Color.BLUE;
		if(s.equals("red"))		return Color.RED;
		if(s.equals("black"))		return Color.BLACK;
		if(s.equals("cyan"))		return Color.CYAN;
		if(s.equals("dark_gray"))	return Color.DARK_GRAY;
		if(s.equals("darkgray"))	return Color.DARK_GRAY;
		if(s.equals("gray"))		return Color.GRAY;
		if(s.equals("green"))		return Color.GREEN;
		if(s.equals("light_gray"))	return Color.LIGHT_GRAY;
		if(s.equals("lightgray"))	return Color.LIGHT_GRAY;
		if(s.equals("magenta"))		return Color.MAGENTA;
		if(s.equals("orange"))		return Color.ORANGE;
		if(s.equals("pink"))		return Color.PINK;
		if(s.equals("white"))		return Color.WHITE;
		if(s.equals("yellow"))		return Color.YELLOW;
        
        
		s = s.toUpperCase();
        
		if(p_html1.matcher(s).matches())
		return colorFromHtmlCode(s);
        
		if(p_html2.matcher(s).matches())
		return colorFromHtmlCode(s);
        
		List l = extractInt(s);
		if(l.size()==3)
		{
			int r = int_(l.get(0));
			int g = int_(l.get(1));
			int b = int_(l.get(2));
			return new Color(r,g,b);
		}
		if(l.size()==4)
		{
			int r = int_(l.get(0));
			int g = int_(l.get(1));
			int b = int_(l.get(2));
			int a = int_(l.get(3));
			return new Color(r,g,b,a);
		}
		int val = int_(s);
		return new Color(val);
	}

    
    
    
	int int_(Object s) {return Integer.parseInt((String) s);}
    
	private Color colorFromHtmlCode(String code) throws Exception
	{return (Color) htmlToColor.t(code);}
    
    
    
	private List extractInt(String s)
	{
		List l = new ArrayList();
		Matcher m = p_int.matcher(s);
		while(m.find()) l.add(m.group());
		return l;
	}

}
