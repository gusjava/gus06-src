package gus06.entity.gus.tostring.desc.short1.image;

import gus06.framework.*;
import java.awt.Image;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151129";}



	public Object t(Object obj) throws Exception
	{
		Image m = (Image) obj;
		return className(m)+" ["+m.getWidth(null)+","+m.getHeight(null)+"]";
	}
	
	private String className(Object obj)
	{return obj.getClass().getSimpleName();}
}
