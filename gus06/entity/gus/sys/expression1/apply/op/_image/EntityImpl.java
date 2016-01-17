package gus06.entity.gus.sys.expression1.apply.op._image;

import gus06.framework.*;
import java.io.File;

public class EntityImpl implements Entity, T, R {

	public String creationDate() {return "20151113";}


	private Service readImage;
	
	public EntityImpl() throws Exception
	{
		readImage = Outside.service(this,"gus.file.read.image.generic");
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
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	public Object r(String key) throws Exception
	{
		if(key.equals("types")) return new Class[]{File.class};
		if(key.equals("keys")) return new String[]{"types"};
		throw new Exception("Unknown key: "+key);
	}
}
