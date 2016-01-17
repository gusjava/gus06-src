package gus06.entity.gus.sys.expression1.apply.op._width;

import gus06.framework.*;
import java.io.File;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Component;
import java.awt.image.RenderedImage;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151129";}



	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return null;
		if(obj instanceof Image)
		{
			Image im = (Image) obj;
			return new Integer(im.getWidth(null));
		}
		if(obj instanceof RenderedImage)
		{
			RenderedImage im = (RenderedImage) obj;
			return new Integer(im.getWidth());
		}
		if(obj instanceof Rectangle)
		{
			Rectangle rect = (Rectangle) obj;
			return new Integer(rect.width);
		}
		if(obj instanceof Component)
		{
			Component comp = (Component) obj;
			return new Integer(comp.getWidth());
		}
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
}
