package gus06.entity.gus.sys.expression1.apply.op._image;

import gus06.framework.*;
import java.io.File;
import java.net.URL;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151113";}


	private Service readImage;
	private Service urlToImage;
	private Service baToImage;
	
	public EntityImpl() throws Exception
	{
		readImage = Outside.service(this,"gus.file.read.image.generic");
		urlToImage = Outside.service(this,"gus.convert.urltoimage");
		baToImage = Outside.service(this,"gus.convert.bytearraytobufferedimage");
	}

	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return null;
		if(obj instanceof File)
		{
			File file = (File) obj;
			return file.isFile()?readImage.t(file):null;
		}
		if(obj instanceof URL)
		{
			URL url = (URL) obj;
			return urlToImage.t(url);
		}
		if(obj instanceof byte[])
		{
			byte[] ba = (byte[]) obj;
			return baToImage.t(ba);
		}
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
}
