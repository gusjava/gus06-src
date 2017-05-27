package gus06.entity.gus.jdbc.mysql.perform.select.all.where;

import gus06.framework.*;
import java.sql.Connection;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20161007";}


	private Service buildSql;
	private Service executeSql;


	public EntityImpl() throws Exception
	{
		buildSql = Outside.service(this,"gus.jdbc.mysql.sql.select.all.where");
		executeSql = Outside.service(this,"gus.jdbc.mysql.perform.sqlexecute");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=3) throw new Exception("Wrong data number: "+o.length);
		
		Connection cx = (Connection) o[0];
		String path = (String) o[1];
		String where = (String) o[2];
		
		String sql = (String) buildSql.t(new String[]{path,where});
		return executeSql.t(new Object[]{cx,sql});
	}
}
