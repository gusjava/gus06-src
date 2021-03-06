package gus06.entity.gus.sys.expression1.apply.op._e_renamefile;

import gus06.framework.*;
import java.io.File;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160611";}


	private Service perform;
	
	public EntityImpl() throws Exception
	{
		perform = Outside.service(this,"gus.dirfile.op.rename");
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
		private File f1;
		public T1(File f1) {this.f1 = f1;}
		
		public Object t(Object obj) throws Exception
		{return new E1(f1,(String) obj);}
	}
	
	private class E1 implements E
	{
		private File f1;
		private String newName;
		
		public E1(File f1, String newName)
		{
			this.f1 = f1;
			this.newName = newName;
		}
		
		public void e() throws Exception
		{perform.p(new Object[]{f1,newName});}
	}
}
