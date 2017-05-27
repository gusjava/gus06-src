package gus06.entity.gus.sys.expression1.apply.op._jdbc_dropuser;

import gus06.framework.*;
import java.sql.Connection;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20161101";}


	private Service perform;
	
	public EntityImpl() throws Exception
	{
		perform = Outside.service(this,"gus.jdbc.mysql.perform.user.drop");
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
			String user = (String) obj;
			return new T2(cx,user);
		}
	}
	
	private class T2 implements T
	{
		private Connection cx;
		private String user;
		
		public T2(Connection cx, String user)
		{
			this.cx = cx;
			this.user = user;
		}
		
		public Object t(Object obj) throws Exception
		{
			String host = (String) obj;
			return new E1(cx,user,host);
		}
	}
	
	
	
	
	private class E1 implements E
	{
		private Connection cx;
		private String user;
		private String host;
		
		public E1(Connection cx, String user, String host)
		{
			this.cx = cx;
			this.user = user;
			this.host = host;
		}
		
		public void e() throws Exception
		{perform.p(new Object[]{cx,user,host});}
	}
}
