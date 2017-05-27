package gus06.entity.gus.sys.expression1.apply.op._jdbc_find_ct_w;

import gus06.framework.*;
import java.sql.Connection;
import java.util.List;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20170514";}


	private Service perform;
	private Service buildWhere;
	
	public EntityImpl() throws Exception
	{
		perform = Outside.service(this,"gus.jdbc.mysql.perform.select.all.where.as.maplist");
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
		{return new T2(cx,(String) obj);}
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
			String where = (String) buildWhere.t(obj);
			List l = (List) perform.t(new Object[]{cx,path,where});
			if(l.size()!=1) throw new Exception("Invalid result number: "+l.size()+" (1 is expected)");
			return l.get(0);
		}
	}
}
