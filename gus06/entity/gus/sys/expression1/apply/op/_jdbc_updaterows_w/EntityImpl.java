package gus06.entity.gus.sys.expression1.apply.op._jdbc_updaterows_w;

import gus06.framework.*;
import java.sql.Connection;
import java.util.Map;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20161020";}


	private Service perform;
	private Service buildWhere;
	
	public EntityImpl() throws Exception
	{
		perform = Outside.service(this,"gus.jdbc.mysql.perform.rows.update.where");
		buildWhere = Outside.service(this,"gus.jdbc.mysql.sql.where");
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
			String tableName = (String) obj;
			return new T2(cx,tableName);
		}
	}
	
	
	private class T2 implements T
	{
		private Connection cx;
		private String tableName;
		
		public T2(Connection cx, String tableName)
		{
			this.cx = cx;
			this.tableName = tableName;
		}
		
		public Object t(Object obj) throws Exception
		{
			String where = (String) buildWhere.t(obj);
			return new T3(cx,tableName,where);
		}
	}
	
	
	
	private class T3 implements T
	{
		private Connection cx;
		private String tableName;
		private String where;
		
		public T3(Connection cx, String tableName, String where)
		{
			this.cx = cx;
			this.tableName = tableName;
			this.where = where;
		}
		
		public Object t(Object obj) throws Exception
		{
			Map map = (Map) obj;
			return new E1(cx,tableName,where,map);
		}
	}
	
	
	private class E1 implements E
	{
		private Connection cx;
		private String tableName;
		private String where;
		private Map map;
		
		public E1(Connection cx, String tableName, String where, Map map)
		{
			this.cx = cx;
			this.tableName = tableName;
			this.where = where;
			this.map = map;
		}
		
		public void e() throws Exception
		{
			perform.p(new Object[]{cx,tableName,where,map});
		}
	}
}
