package gus06.entity.gus.file.write.image.png;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import gus06.framework.*;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20150929";}

	
	private Service toBufferedImage;
	
	public EntityImpl() throws Exception
	{
		toBufferedImage = Outside.service(this,"gus.find.bufferedimage");
	}
	

	public void p(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);

		File file = (File) o[0];
		BufferedImage im = (BufferedImage) toBufferedImage.t(o[1]);
		
		ImageIO.write(im,"png",file);
	}
}
