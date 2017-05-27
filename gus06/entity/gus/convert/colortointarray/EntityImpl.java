package gus06.entity.gus.convert.colortointarray;

import gus06.framework.*;
import java.awt.Color;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160830";}
	
	
	public Object t(Object obj) throws Exception
	{
		Color c = (Color) obj;
		
		int r = c.getRed();
		int g = c.getGreen();
		int b = c.getBlue();
		
		return new int[]{r,g,b};
	}
}
