package gus06.entity.gus.mouse.position.str;

import gus06.framework.*;
import java.awt.Point;
import java.awt.MouseInfo;

public class EntityImpl implements Entity, G {

	public String creationDate() {return "20160407";}

	
	public Object g() throws Exception
	{
		Point p = MouseInfo.getPointerInfo().getLocation();
		return p.x+":"+p.y;
	}
}
