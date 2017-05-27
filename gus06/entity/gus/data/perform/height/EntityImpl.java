package gus06.entity.gus.data.perform.height;

import gus06.framework.*;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Component;
import java.awt.image.RenderedImage;
import java.awt.Dimension;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160820";}



	
	public Object t(Object obj) throws Exception
	{
		if(obj instanceof Image)
		{
			Image im = (Image) obj;
			return new Integer(im.getHeight(null));
		}
		if(obj instanceof RenderedImage)
		{
			RenderedImage im = (RenderedImage) obj;
			return new Integer(im.getHeight());
		}
		if(obj instanceof Rectangle)
		{
			Rectangle rect = (Rectangle) obj;
			return new Integer(rect.height);
		}
		if(obj instanceof Dimension)
		{
			Dimension dim = (Dimension) obj;
			return new Integer(dim.height);
		}
		if(obj instanceof Component)
		{
			Component comp = (Component) obj;
			return new Integer(comp.getHeight());
		}
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
}
