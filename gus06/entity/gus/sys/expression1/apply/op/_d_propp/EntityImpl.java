package gus06.entity.gus.sys.expression1.apply.op._d_propp;

import gus06.framework.*;
import java.io.File;
import java.util.Map;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20161208";}
	
	
	private Service readProp;
	
	public EntityImpl() throws Exception
	{
		readProp = Outside.service(this,"gus.file.read.properties.autosaver.strict");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return null;
		if(obj instanceof File) return new T1(obj);
		if(obj instanceof File[]) return new T1(obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	
	private class T1 implements T
	{
		private Object data;
		public T1(Object data) {this.data = data;}
		
		public Object t(Object obj) throws Exception
		{return build(data,(String) obj);}
	}
	
	
	private Object build(Object obj, String s) throws Exception
	{
		if(obj instanceof File)
		{
			File d = (File) obj;
			return load(d,s);
		}
		if(obj instanceof File[])
		{
			File[] dd = (File[]) obj;
			Map[] pp = new Map[dd.length];
			for(int i=0;i<dd.length;i++) pp[i] = load(dd[i],s);
			return pp;
		}
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	
	
	private Map load(File dir, String s) throws Exception
	{
		File f1 = new File(dir,s);
		if(f1.isFile()) return load(f1);
		
		File f2 = new File(dir,s+".properties");
		if(f2.isFile()) return load(f2);
		
		return null;
	}
	
	
	private Map load(File file) throws Exception
	{return (Map) readProp.t(file);}
}
