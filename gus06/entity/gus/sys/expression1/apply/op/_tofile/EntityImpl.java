package gus06.entity.gus.sys.expression1.apply.op._tofile;

import gus06.framework.*;
import java.io.File;
import java.util.Map;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151109";}


	private Service buildFile;
	
	public EntityImpl() throws Exception
	{
		buildFile = Outside.service(this,"gus.sys.expression1.file.build");
	}

	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		Object value = o[0];
		Map opMap = (Map) o[1];
		
		if(value==null) return null;
		
		if(value instanceof File) return ((File) value).getCanonicalFile();
		if(value instanceof String) return file((String) value,opMap);
		
		if(value instanceof File[])
		{
			File[] ff = (File[]) value;
			if(ff.length!=1) throw new Exception("Invalid array length: "+ff.length);
			return ff[0].getCanonicalFile();
		}
		
		throw new Exception("Invalid data type: "+value.getClass().getName());
	}
	
	private File file(String s, Map opMap) throws Exception
	{return (File) buildFile.t(new Object[]{s,opMap});}
}
