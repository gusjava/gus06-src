package gus06.entity.gus.sys.expression1.apply.op._jdbc_tabletocolumns;

import gus06.framework.*;
import java.sql.Connection;
import java.sql.ResultSet;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160409";}


	private Service perform;
	
	public EntityImpl() throws Exception
	{
		perform = Outside.service(this,"gus.jdbc.mysql.perform.table.findcolumns");
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
			String path = (String) obj;
			return perform.t(new Object[]{cx,path});
		}
	}
}
