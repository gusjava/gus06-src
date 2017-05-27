package gus06.entity.gus.tostring.desc.short1.color;

import gus06.framework.*;
import java.awt.Color;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20170425";}


	private Service colorToString;
	
	
	public EntityImpl() throws Exception
	{
		colorToString = Outside.service(this,"gus.awt.color.tostring");
	}



	public Object t(Object obj) throws Exception
	{
		Color c = (Color) obj;
		return "Color: "+colorToString.t(c);
	}
}
