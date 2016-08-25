package gus06.entity.gus.data.perform.width;

import gus06.framework.*;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Component;
import java.awt.image.RenderedImage;
import java.util.List;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160820";}


	private Service performDoubleArray;
	private Service performIntArray;
	private Service performList;

	public EntityImpl() throws Exception
	{
		performDoubleArray = Outside.service(this,"gus.math.tabdouble.width");
		performIntArray = Outside.service(this,"gus.math.tabint.width");
		performList = Outside.service(this,"gus.list.width");
	}


	
	public Object t(Object obj) throws Exception
	{
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
		if(obj instanceof double[])
		{
			return performDoubleArray.t(obj);
		}
		if(obj instanceof int[])
		{
			return performIntArray.t(obj);
		}
		if(obj instanceof List)
		{
			return performList.t(obj);
		}
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
}
