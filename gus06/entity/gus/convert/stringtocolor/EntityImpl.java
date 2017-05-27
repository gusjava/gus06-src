package gus06.entity.gus.convert.stringtocolor;

import gus06.framework.*;
import java.awt.Color;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20140729";}


	private Service htmlToColor;
	private Service nameToColor;
	private Service rgbToColor;

	public EntityImpl() throws Exception
	{
		htmlToColor = Outside.service(this,"gus.convert.stringtocolor.html");
		nameToColor = Outside.service(this,"gus.convert.stringtocolor.name");
		rgbToColor = Outside.service(this,"gus.convert.stringtocolor.rgb");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		if(obj==null) return null;
		
		String s = (String) obj;
		if(s.equals("")) return null;
		
		Color c1 = (Color) htmlToColor.t(s);
		if(c1!=null) return c1;
        
		Color c2 = (Color) nameToColor.t(s);
		if(c2!=null) return c2;
        
		Color c3 = (Color) rgbToColor.t(s);
		if(c3!=null) return c3;
        
		return null;
	}
}
