package gus06.entity.gus.awt.color.random;

import gus06.framework.*;
import java.awt.Color;

public class EntityImpl implements Entity, G {

	public String creationDate() {return "20160505";}

	
	
	public Object g() throws Exception
	{
		int r = rand(256);
		int g = rand(256);
		int b = rand(256);
		
		return new Color(r,g,b);
	}
	
	private int rand(int n)
	{return (int)(Math.random()*n);}
}
