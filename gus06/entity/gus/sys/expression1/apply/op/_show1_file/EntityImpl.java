package gus06.entity.gus.sys.expression1.apply.op._show1_file;

import gus06.framework.*;
import java.io.File;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160612";}


	private Service perform;
	
	
	public EntityImpl() throws Exception
	{
		perform = Outside.service(this,"gus.swing.frame.show.function");
	}

	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return null;
		
		if(obj instanceof File) return new T1(obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	
	private class T1 implements T
	{
		private Object data;
		
		public T1(Object data)
		{this.data = data;}
		
		public Object t(Object obj) throws Exception
		{return new E1(data,(String) obj);}
	}
	
	
	private class E1 implements E
	{
		private Object data;
		private String title;
		
		public E1(Object data, String title)
		{
			this.data = data;
			this.title = title;	
		}
		
		public void e() throws Exception
		{perform.v(title,data);}
	}
}
