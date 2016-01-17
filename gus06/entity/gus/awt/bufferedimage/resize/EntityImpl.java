package gus06.entity.gus.awt.bufferedimage.resize;

import gus06.framework.*;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.awt.image.renderable.ParameterBlock;
import java.awt.geom.AffineTransform;
import javax.media.jai.InterpolationNearest;
import javax.media.jai.JAI;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20141114";}


	public EntityImpl() throws Exception
	{
	}
	
	
	public Object t(Object obj) throws Exception
	{
		if(obj instanceof BufferedImage[])
		{
			BufferedImage[] b = (BufferedImage[]) obj;
			if(b.length!=2) throw new Exception("Wrong data number: "+b.length);
			
			float xScale = (float) b[1].getWidth() / (float) b[0].getWidth();
			float yScale = (float) b[1].getHeight() / (float) b[0].getHeight();
			return toBufferedImage(resize(b[0],xScale,yScale));
		}
		return null;
	}
	
	
	
	
	private RenderedImage resize(RenderedImage image, float xScale, float yScale)
	{
		ParameterBlock pb = new ParameterBlock();
		pb.addSource(image);
		pb.add(xScale); // The xScale
		pb.add(yScale); // The yScale
		pb.add(0.0f); // The x translation
		pb.add(0.0f); // The y translation
		pb.add(new InterpolationNearest());
		return JAI.create("scale",pb);
	}
	
	
	
	private BufferedImage toBufferedImage(RenderedImage image)
	{
		BufferedImage buffImg = new BufferedImage(image.getWidth(),image.getHeight(),BufferedImage.TYPE_INT_RGB);
		Graphics2D g = buffImg.createGraphics();
		g.drawRenderedImage(image,AffineTransform.getTranslateInstance(0,0));
		g.dispose();
		return buffImg;
	}
}
