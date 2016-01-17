package gus06.entity.gus.sys.expression1.apply.op._child;

import gus06.framework.*;
import java.io.File;

public class EntityImpl implements Entity, T, R {

	public String creationDate() {return "20160107";}
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return null;
		if(obj instanceof File) return new T1((File) obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	public Object r(String key) throws Exception
	{
		if(key.equals("input")) return new Class[]{File.class};
		if(key.equals("output")) return new Class[]{T.class};
		
		if(key.equals("keys")) return new String[]{"input","output"};
		throw new Exception("Unknown key: "+key);
	}
	
	
	private class T1 implements T
	{
		private File dir;
		public T1(File dir) {this.dir = dir;}
		
		public Object t(Object obj) throws Exception
		{return new File(dir,(String) obj);}
	}
}
