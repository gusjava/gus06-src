package gus06.entity.gus.sys.expression1.apply.op._file1;

import gus06.framework.*;
import java.io.File;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151110";}


	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return null;
		if(obj instanceof File) return file1((File) obj);
		if(obj instanceof String) return file1(toFile((String) obj));
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	
	private File file1(File file) throws Exception
	{
		if(file.isFile()) return file;
		if(file.isDirectory()) return null;
		
		file.getParentFile().mkdirs();
		file.createNewFile();
		return file;
	}
	
	private File toFile(String s) throws Exception
	{return new File(s).getCanonicalFile();}
}
