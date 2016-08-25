package gus06.entity.gus.file.read.image.generic;

import java.awt.image.BufferedImage;
import java.io.File;
import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150616";}


	private Service findReader;
	private Service err0;
	private BufferedImage errImage;
	
	
	public EntityImpl() throws Exception
	{
		findReader = Outside.service(this,"gus.file.read.image.generic.findreader");
		err0 = Outside.service(this,"gus.file.read.image.generic.err0");
		errImage = (BufferedImage) err0.g();
	}


	public Object t(Object obj) throws Exception
	{
		File file = (File) obj;
		if(file==null || !file.isFile())
			throw new Exception("Invalid file: "+file);
		
		try
		{
			T reader = (T) findReader.t(file);
			Object image = reader.t(file);
			return image!=null?image:errImage;
		}
		catch(Exception e)
		{
			String message = "Failed to read image from file: "+file.getAbsolutePath();
			Outside.err(this,"t(Object)",new Exception(message,e));
			return errImage;
		}
	}
}
