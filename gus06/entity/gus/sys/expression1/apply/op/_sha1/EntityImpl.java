package gus06.entity.gus.sys.expression1.apply.op._sha1;

import gus06.framework.*;
import java.io.File;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151110";}


	private Service buildSha1;
	
	public EntityImpl() throws Exception
	{
		buildSha1 = Outside.service(this,"gus.crypto.hash.sha1");
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
			return file.isFile()?buildSha1.t(file):null;
		}
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
}
