package gus06.entity.gus.sys.expression1.apply.op._filesize;

import gus06.framework.*;
import java.util.Map;
import java.io.File;
import java.util.Set;
import java.util.List;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160711";}
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return null;
		
		if(obj instanceof String) return fileSize(toFile((String) obj));
		if(obj instanceof File) return fileSize((File) obj);
		if(obj instanceof File[]) return fileSize((File[]) obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	
	
	private Long fileSize(File file)
	{
		if(!file.exists()) return null;
		return new Long(totalSize(file));
	}
	
	private Long fileSize(File[] files)
	{
		return new Long(totalSize(files));
	}
	
	
	
	
	
	private long totalSize(File path)
	{
		if(!path.exists()) return 0;
		if(path.isFile()) return path.length();
		
		long size = 0;
		File[] ff = path.listFiles();
		for(int i=0;i<ff.length;i++)
			size += totalSize(ff[i]);
		return size;
	}
	
	private long totalSize(File[] paths)
	{
		long size = 0;
		for(File path:paths)
			size += totalSize(path);
		return size;
	}
	
	private File toFile(String s) throws Exception
	{return new File(s).getCanonicalFile();}
}
