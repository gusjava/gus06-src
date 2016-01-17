package gus06.entity.gus.awt.color.distance.rgb;

import gus06.framework.*;
import java.awt.Color;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20141122";}
	
	
	public Object t(Object obj) throws Exception
	{
		Color[] c = (Color[]) obj;
		if(c.length!=2) throw new Exception("Wrong data number: "+c.length);
		return new Double(distance(c[0],c[1]));
	}
	
	private double distance(Color c1, Color c2)
	{
		int b = c1.getBlue()-c2.getBlue();
		int r = c1.getRed()-c2.getRed();
		int g = c1.getGreen()-c2.getGreen();
		
		return b*b + r*r + g*g;
	}
}
