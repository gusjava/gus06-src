package gus06.entity.gus.file.write.image.jpg;

import gus06.framework.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20141015";}
	
	
	public void p(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		File file = (File) o[0];
		BufferedImage image = (BufferedImage) o[1];
		
		ImageIO.write(image,"jpg",file);
	}
}
