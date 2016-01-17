package gus06.entity.gus.convert.bytearraytoimage;

import gus06.framework.*;
import java.io.InputStream;
import javax.imageio.ImageIO;
import java.io.ByteArrayInputStream;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150930";}


	public Object t(Object obj) throws Exception
	{
		if(obj==null) return null;
		
		byte[] bytes = (byte[]) obj;
		InputStream in = new ByteArrayInputStream(bytes);
		return ImageIO.read(in);
	}
}
