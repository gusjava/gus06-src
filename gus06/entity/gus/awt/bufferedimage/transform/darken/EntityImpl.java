package gus06.entity.gus.awt.bufferedimage.transform.darken;

import gus06.framework.*;
import java.awt.image.BufferedImage;
import java.awt.image.RescaleOp;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20141115";}


	private Service toImage;


	public EntityImpl() throws Exception
	{
		toImage = Outside.service(this,"gus.find.bufferedimage");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		BufferedImage img = (BufferedImage) toImage.t(obj);
		RescaleOp op = new RescaleOp(.7f,0,null);
    		return op.filter(img,null);
	}
}
