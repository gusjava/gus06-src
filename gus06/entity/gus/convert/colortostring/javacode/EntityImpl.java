package gus06.entity.gus.convert.colortostring.javacode;

import gus06.framework.*;
import java.awt.Color;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160521";}
	
	
	public Object t(Object obj) throws Exception
	{return colorToJava((Color) obj);}

    
	private String colorToJava(Color c) throws Exception
	{
		int r = c.getRed();
		int g = c.getGreen();
		int b = c.getBlue();
		return "new Color("+r+","+g+","+b+")";
	}
}

