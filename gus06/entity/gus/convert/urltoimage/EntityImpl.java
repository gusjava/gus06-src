package gus06.entity.gus.convert.urltoimage;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20140909";}


	private Service urlToFile;
	private Service readImage;


	public EntityImpl() throws Exception
	{
		urlToFile = Outside.service(this,"gus.convert.urltofile");
		readImage = Outside.service(this,"gus.file.read.image.imageio");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		if(obj==null) return null;
		return readImage.t(urlToFile.t(obj));
	}
}
