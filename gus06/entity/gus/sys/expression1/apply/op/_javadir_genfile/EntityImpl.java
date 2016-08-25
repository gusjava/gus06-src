package gus06.entity.gus.sys.expression1.apply.op._javadir_genfile;

import gus06.framework.*;
import java.io.File;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160410";}


	private Service perform;
	
	public EntityImpl() throws Exception
	{
		perform = Outside.service(this,"gus.java.srcdir.generate.fromsrc");
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
		private File dir;
		public T1(File dir) {this.dir = dir;}
		
		public Object t(Object obj) throws Exception
		{
			String src = (String) obj;
			return new E1(dir,src);
		}
	}
	
	private class E1 implements E
	{
		private File dir;
		private String src;
		
		public E1(File dir, String src)
		{
			this.dir = dir;
			this.src = src;
		}
		
		public void e() throws Exception
		{
			perform.p(new Object[]{dir,src});
		}
	}
}
