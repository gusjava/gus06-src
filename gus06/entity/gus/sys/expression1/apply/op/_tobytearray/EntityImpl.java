package gus06.entity.gus.sys.expression1.apply.op._tobytearray;

import gus06.framework.*;
import java.io.File;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160303";}
	
	private Service readBinary;
	
	public EntityImpl() throws Exception
	{
		readBinary = Outside.service(this,"gus.file.read.raw");
	}
	
		
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return null;
		if(obj instanceof byte[]) return obj;
		if(obj instanceof String) return ((String) obj).getBytes("UTF8");
		
		if(obj instanceof File)
		{
			File file = (File) obj;
			return file.isFile()?readBinary.t(file):null;
		}
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
}
