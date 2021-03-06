package gus06.entity.gus.sys.expression1.apply.op._e_copyup;

import gus06.framework.*;
import java.io.File;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160715";}


	private Service perform;
	
	public EntityImpl() throws Exception
	{
		perform = Outside.service(this,"gus.dirfile.op.copyup.autorename");
	}

	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return null;
		
		if(obj instanceof File) return new E1((File) obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	
	private class E1 implements E
	{
		private File f;
		
		public E1(File f)
		{this.f = f;}
		
		public void e() throws Exception
		{perform.p(f);}
	}
}
