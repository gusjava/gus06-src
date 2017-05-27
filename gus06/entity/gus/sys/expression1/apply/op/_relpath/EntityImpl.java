package gus06.entity.gus.sys.expression1.apply.op._relpath;

import gus06.framework.*;
import java.io.File;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20161207";}
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return null;
		if(obj instanceof File) return new T1((File) obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	
	private class T1 implements T
	{
		private File file;
		public T1(File file) {this.file = file;}
		
		public Object t(Object obj) throws Exception
		{return buildPath(file,(File) obj);}
	}
	
	
	private String buildPath(File file, File root) throws Exception
	{
		String f = file.getAbsolutePath();
		String r = root.getAbsolutePath();
		
		if(!f.startsWith(r)) throw new Exception("Path not included inside root: "+f);
		
		f = f.substring(r.length());
		if(f.startsWith(File.separator)) f = f.substring(1);
		
		return f;
	}
}
