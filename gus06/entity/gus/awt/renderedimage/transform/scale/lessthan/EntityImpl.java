package gus06.entity.gus.awt.renderedimage.transform.scale.lessthan;

import java.awt.image.RenderedImage;
import java.awt.image.renderable.ParameterBlock;
import javax.media.jai.InterpolationNearest;
import javax.media.jai.JAI;
import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160529";}
	


	public Object t(Object obj) throws Exception
	{
		Object[] t = (Object[]) obj;
		if(t.length!=2) throw new Exception("Wrong data number: "+t.length);

		RenderedImage image = (RenderedImage) t[0];
		float limit = Float.parseFloat((String) t[1]);
		
		
		long size = image.getHeight()*image.getWidth();
		if(size<=limit) return image;
		
		float factor = (float) Math.sqrt((double)limit/(double)size);
		return resize(image,factor);
	}
	
	
	
	private RenderedImage resize(RenderedImage image, float factor)
	{
		ParameterBlock pb = new ParameterBlock();
		pb.addSource(image);
		pb.add(factor); // The xScale
		pb.add(factor); // The yScale
		pb.add(0.0f); // The x translation
		pb.add(0.0f); // The y translation
		pb.add(new InterpolationNearest());
		return JAI.create("scale",pb);
	}


	
	static{System.setProperty("com.sun.media.jai.disableMediaLib","true");}
}
