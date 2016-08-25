package gus06.entity.gus.convert.bytearraytobufferedimage;

import gus06.framework.*;
import java.io.InputStream;
import javax.imageio.ImageIO;
import java.io.ByteArrayInputStream;
import java.awt.image.BufferedImage;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150930";}


	public Object t(Object obj) throws Exception
	{
		if(obj==null) return null;
		
		byte[] bytes = (byte[]) obj;
		InputStream in = new ByteArrayInputStream(bytes);
		BufferedImage bi = ImageIO.read(in);
		in.close();
		return bi;
	}
}
