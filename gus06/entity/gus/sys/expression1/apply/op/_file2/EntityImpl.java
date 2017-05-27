package gus06.entity.gus.sys.expression1.apply.op._file2;

import gus06.framework.*;
import java.io.File;
import java.util.Map;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20161214";}


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
		if(value instanceof File) return file1((File) value);
		if(value instanceof String) return file1(file((String) value, opMap));
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	
	private File file1(File file) throws Exception
	{
		if(!file.isFile()) throw new Exception("File not found at path: "+file);
		return file;
	}
	
	private File file(String s, Map opMap) throws Exception
	{return (File) buildFile.t(new Object[]{s,opMap});}
}
