package gus06.entity.gus.file.read.image.preview.raw;

import gus06.framework.*;
import java.io.File;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.ByteArrayOutputStream;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160602";}


	private Service readImage;


	public EntityImpl() throws Exception
	{
		readImage = Outside.service(this,"gus.file.read.image.preview");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		File file = (File) obj;
		BufferedImage image = (BufferedImage) readImage.t(file);
		
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
