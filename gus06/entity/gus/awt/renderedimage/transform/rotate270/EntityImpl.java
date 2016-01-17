package gus06.entity.gus.awt.renderedimage.transform.rotate270;

import java.awt.image.RenderedImage;
import java.awt.image.renderable.ParameterBlock;
import javax.media.jai.JAI;
import javax.media.jai.operator.TransposeDescriptor;
import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150929";}

	
	public Object t(Object obj) throws Exception
	{
		RenderedImage image = (RenderedImage) obj;
		ParameterBlock pb = new ParameterBlock();
		pb.addSource(image);
		pb.add(TransposeDescriptor.ROTATE_270);
		return JAI.create("transpose",pb);
	}

	static{System.setProperty("com.sun.media.jai.disableMediaLib","true");}
}
