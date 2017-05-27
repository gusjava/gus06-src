package gus06.entity.gus.awt.bufferedimage.tojpg.raw;

import gus06.framework.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import javax.imageio.ImageIO;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20170210";}
	
	
	public Object t(Object obj) throws Exception
	{
		BufferedImage image = (BufferedImage) obj;
		ByteArrayOutputStream baos = null;
		byte[] raw = null;
		
		try
		{
			baos = new ByteArrayOutputStream();
			ImageIO.write(image,"jpg",baos);
			baos.flush();
			raw = baos.toByteArray();
		}
		finally
		{if(baos!=null) baos.close();}
		
		return raw;
	}
}