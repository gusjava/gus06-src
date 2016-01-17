package gus06.entity.gus.find.dimension;

import gus06.framework.*;
import java.awt.Dimension;
import java.awt.Rectangle;
import javax.swing.JFrame;
import java.awt.Point;
import java.awt.image.RenderedImage;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20141115";}
	
	
	public Object t(Object obj) throws Exception
	{
		if(obj==null) return null;
		if(obj instanceof Dimension) return obj;
		
		if(obj instanceof int[]) return intArrayToDim((int[]) obj);
		if(obj instanceof Point) return pointToDim((Point) obj);
		if(obj instanceof JFrame) return jframeToDim((JFrame) obj);
		if(obj instanceof Rectangle) return rectangleToDim((Rectangle) obj);
		if(obj instanceof RenderedImage) return imageToDim((RenderedImage) obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	
	
	private Dimension intArrayToDim(int[] v)
	{return new Dimension(v[0],v[1]);}
	
	private Dimension pointToDim(Point v)
	{return new Dimension(v.x,v.y);}
	
	private Dimension imageToDim(RenderedImage v)
	{return new Dimension(v.getWidth(),v.getHeight());}
	
	private Dimension jframeToDim(JFrame v)
	{return new Dimension(v.getWidth(),v.getHeight());}
	
	private Dimension rectangleToDim(Rectangle v)
	{return new Dimension(v.width,v.height);}
}
