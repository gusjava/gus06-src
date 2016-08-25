package gus06.entity.gus.sys.expression1.apply.op._jdbc_initdb1;

import gus06.framework.*;
import java.sql.Connection;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160316";}


	private Service createDb;
	private Service createUser;
	private Service grantUser;
	
	public EntityImpl() throws Exception
	{
		createDb = Outside.service(this,"gus.jdbc.mysql.perform.db.create");
		createUser = Outside.service(this,"gus.jdbc.mysql.perform.user.create");
		grantUser = Outside.service(this,"gus.jdbc.mysql.perform.user.grant.db.all");
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
		{
			String user = dbName;
			String pwd = dbName;
			String host = "localhost";
			
			createDb.p(new Object[]{cx,dbName});
			createUser.p(new Object[]{cx,user,host,pwd});
			grantUser.p(new Object[]{cx,dbName,user,host});
		}
	}
}
