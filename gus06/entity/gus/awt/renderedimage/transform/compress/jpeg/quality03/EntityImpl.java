package gus06.entity.gus.awt.renderedimage.transform.compress.jpeg.quality03;

import java.awt.image.RenderedImage;
import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151004";}

	public final static String QUALITY = "0.3";


	private Service perform;

	public EntityImpl() throws Exception
	{
		perform = Outside.service(this,"gus.awt.renderedimage.transform.compress.jpeg.quality");
	}
	
	public Object t(Object obj) throws Exception
	{
		RenderedImage image = (RenderedImage) obj;
		return perform.t(new Object[]{image,QUALITY});
	}
}