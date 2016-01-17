package gus06.entity.gus.sys.expression1.apply.op._mime;

import gus06.framework.*;
import java.io.File;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151110";}


	private Service buildMime;
	
	public EntityImpl() throws Exception
	{
		buildMime = Outside.service(this,"gus.file.mime.tika.detect.asstring");
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
			return file.isFile()?buildMime.t(file):null;
		}
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
}
