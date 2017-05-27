package gus06.entity.gus.sys.expression1.apply.op._jdbc_createdb;

import gus06.framework.*;
import java.sql.Connection;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160316";}


	private Service perform;
	
	public EntityImpl() throws Exception
	{
		perform = Outside.service(this,"gus.jdbc.mysql.perform.db.create");
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
		public T1(Connection cx) {this.cx = cx;}
		
		public Object t(Object obj) throws Exception
		{
			String dbName = (String) obj;
			return new E1(cx,dbName);
		}
	}
	
	private class E1 implements E
	{
		private Connection cx;
		private String dbName;
		
		public E1(Connection cx, String dbName)
		{
			this.cx = cx;
			this.dbName = dbName;
		}
		
		public void e() throws Exception
		{perform.p(new Object[]{cx,dbName});}
	}
}
