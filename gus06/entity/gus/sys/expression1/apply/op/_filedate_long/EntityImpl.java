package gus06.entity.gus.sys.expression1.apply.op._filedate_long;

import gus06.framework.*;
import java.io.File;
import java.util.Date;
import java.util.Map;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20170303";}


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
		
		if(value instanceof String) return fileDate(file((String) value, opMap));
		if(value instanceof File) return fileDate((File) value);
		
		throw new Exception("Invalid data type: "+value.getClass().getName());
	}
	
	
	
	private Long fileDate(File file)
	{
		if(!file.exists()) return null;
		return new Long(file.lastModified());
	}
	
	private File file(String s, Map opMap) throws Exception
	{return (File) buildFile.t(new Object[]{s,opMap});}
}
