package gus06.entity.gus.file.write.generic;

import gus06.framework.*;
import java.io.File;
import java.awt.image.BufferedImage;
import java.util.Map;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20150530";}


	private Service writeString;
	private Service writeBufferedImage;
	private Service writeProperties;
	private Service writeFile;
	

	public EntityImpl() throws Exception
	{
		writeString = Outside.service(this,"gus.file.write.string.autodetect");
		writeBufferedImage = Outside.service(this,"gus.file.write.image.jpg");
		writeProperties = Outside.service(this,"gus.file.write.properties");
		writeFile = Outside.service(this,"gus.file.write.file");
	}
	
	
	public void p(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		findWriter(o[1]).p(o);
	}
	
	
	
	private P findWriter(Object data) throws Exception
	{
		if(data instanceof String) return writeString;
		if(data instanceof BufferedImage) return writeBufferedImage;
		if(data instanceof Map) return writeProperties;
		if(data instanceof File) return writeFile;
		
		throw new Exception("Unsupported data type: "+data.getClass().getName());
	}
}
