package gus06.entity.gus.sys.expression1.apply.op._write_text;

import gus06.framework.*;
import java.io.File;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160408";}
	


	private Service writeFile;
	
	public EntityImpl() throws Exception
	{
		writeFile = Outside.service(this,"gus.file.write.string.cs.default0");
	}

	
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
		{return new E1(file,obj);}
	}
	
	
	private class E1 implements E
	{
		private File file;
		private String text;
		
		public E1(File file, Object data) throws Exception
		{
			this.file = file;
			this.text = toString_(data);
		}
		
		public void e() throws Exception
		{writeFile.p(new Object[]{file,text});}
	}
	
	
	private String toString_(Object obj) throws Exception
	{
		if(obj==null) throw new Exception("Invalid null value");
		if(obj instanceof String) return (String) obj;
		if(obj instanceof StringBuffer) return obj.toString();
		if(obj instanceof Number) return obj.toString();
		if(obj instanceof Boolean) return obj.toString();
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
}
