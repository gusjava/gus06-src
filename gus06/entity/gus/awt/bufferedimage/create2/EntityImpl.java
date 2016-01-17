package gus06.entity.gus.awt.bufferedimage.create2;

import java.awt.image.BufferedImage;
import gus06.framework.*;
import java.awt.Dimension;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150930";}


	private Service toDim;
	
	public EntityImpl() throws Exception
	{toDim = Outside.service(this,"gus.find.dimension");}
	
	
	
	public Object t(Object obj) throws Exception
	{
		Dimension dim = (Dimension) toDim.t(obj);
		return new BufferedImage(dim.width,dim.height,BufferedImage.TYPE_INT_RGB);
	}
}
