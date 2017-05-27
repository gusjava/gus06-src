package gus06.entity.gus.awt.color.tostring;

import gus06.framework.*;
import java.awt.Color;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20170425";}

	
	
	public Object t(Object obj) throws Exception
	{
		Color c = (Color) obj;
		return "["+c.getRed()+","+c.getGreen()+","+c.getBlue()+"]";
	}
}
