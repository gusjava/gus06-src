package gus06.entity.gus.sys.expression1.apply.op._jdbc_sqlquery;

import gus06.framework.*;
import java.sql.Connection;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151115";}


	private Service sqlQuery;
	
	public EntityImpl() throws Exception
	{
		sqlQuery = Outside.service(this,"gus.jdbc.mysql.perform.sqlexecute");
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
			String query = (String) obj;
			return sqlQuery.t(new Object[]{cx,query});
		}
	}
}
