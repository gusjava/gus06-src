package gus06.entity.gus.sys.expression1.apply.op._child;

import gus06.framework.*;
import java.io.File;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160107";}
	
	
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
			return new File(d,s);
		}
		if(obj instanceof File[])
		{
			File[] d1 = (File[]) obj;
			File[] d2 = new File[d1.length];
			for(int i=0;i<d1.length;i++) d2[i] = new File(d1[i],s);
			return d2;
		}
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
}
