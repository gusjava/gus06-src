package gus06.entity.gus.mouse.position;

import gus06.framework.*;
import java.awt.Point;
import java.awt.MouseInfo;

public class EntityImpl implements Entity, G {

	public String creationDate() {return "20160407";}

	
	public Object g() throws Exception
	{
		Point p = MouseInfo.getPointerInfo().getLocation();
		return new int[]{p.x,p.y};
	}
}
