package gus06.entity.gus.awt.renderedimage.transform.scale.lessthan750000;

import java.awt.image.RenderedImage;
import java.awt.image.renderable.ParameterBlock;
import javax.media.jai.InterpolationNearest;
import javax.media.jai.JAI;
import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160526";}

	public static final String LIMIT = "750000";


	private Service perform;

	public EntityImpl() throws Exception
	{
		perform = Outside.service(this,"gus.awt.renderedimage.transform.scale.lessthan");
	}

	public Object t(Object obj) throws Exception
	{
		RenderedImage image = (RenderedImage) obj;
		return perform.t(new Object[]{image,LIMIT});
	}
}
