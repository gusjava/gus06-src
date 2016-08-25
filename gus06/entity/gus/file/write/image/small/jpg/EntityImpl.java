package gus06.entity.gus.file.write.image.small.jpg;

import java.awt.image.RenderedImage;
import java.io.File;
import gus06.framework.*;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20160526";}


	
	private Service resizeLessThan;
	private Service writeJpeg09;


	public EntityImpl() throws Exception
	{
		resizeLessThan = Outside.service(this,"gus.awt.renderedimage.transform.scale.lessthan500000");
		writeJpeg09 = Outside.service(this,"gus.file.write.image.imageio.jpg.quality09");
	}


	public void p(Object obj) throws Exception
	{
		Object[] t = (Object[]) obj;
		if(t.length!=2) throw new Exception("Wrong data number: "+t.length);

		File file = (File) t[0];
		RenderedImage image = (RenderedImage) t[1];
		
		image = (RenderedImage) resizeLessThan.t(image);
		writeJpeg09.p(new Object[]{file,image});
	}
}
