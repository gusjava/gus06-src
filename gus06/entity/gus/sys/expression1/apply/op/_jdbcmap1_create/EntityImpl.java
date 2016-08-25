package gus06.entity.gus.sys.expression1.apply.op._jdbcmap1_create;

import gus06.framework.*;
import java.sql.Connection;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160409";}


	private Service create;
	
	public EntityImpl() throws Exception
	{
		create = Outside.service(this,"gus.sys.jdbcmap1.perform.table.create");
	}

	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return null;
		if(obj instanceof Connection) return new T1((Connection) obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	
	private class T1 implements T
	{
		private Connection cx;
		
		public T1(Connection cx)
		{this.cx = cx;}
		
		public Object t(Object obj) throws Exception
		{
			String path = (String) obj;
			return new T2(cx,path);
		}
	}
	
	private class T2 implements T
	{
		private Connection cx;
		private String path;
		
		public T2(Connection cx, String path)
		{
			this.cx = cx;
			this.path = path;
		}
		
		public Object t(Object obj) throws Exception
		{
			return new E1(cx,path,obj);
		}
	}
	
	private class E1 implements E
	{
		private Connection cx;
		private String path;
		private Object def;
		
		public E1(Connection cx, String path, Object def)
		{
			this.cx = cx;
			this.path = path;
			this.def = def;
		}
		
		public void e() throws Exception
		{create.p(new Object[]{cx,path,def});}
	}
}
