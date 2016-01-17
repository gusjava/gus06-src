package gus06.entity.gus.awt.renderedimage.transform.flip.vertical;

import java.awt.image.RenderedImage;
import java.awt.image.renderable.ParameterBlock;
import javax.media.jai.JAI;
import javax.media.jai.operator.TransposeDescriptor;
import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151001";}

	
	public Object t(Object obj) throws Exception
	{
		RenderedImage image = (RenderedImage) obj;
		ParameterBlock pb = new ParameterBlock();
		pb.addSource(image);
		pb.add(TransposeDescriptor.FLIP_VERTICAL);
		return JAI.create("transpose",pb);
	}

	static{System.setProperty("com.sun.media.jai.disableMediaLib","true");}
}
