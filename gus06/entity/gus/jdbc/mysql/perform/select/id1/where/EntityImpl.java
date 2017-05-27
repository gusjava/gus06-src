package gus06.entity.gus.jdbc.mysql.perform.select.id1.where;

import gus06.framework.*;
import java.sql.Connection;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20170517";}


	private Service buildSql;
	private Service executeSql;
	private Service findPrimaryKey;


	public EntityImpl() throws Exception
	{
		buildSql = Outside.service(this,"gus.jdbc.mysql.sql.select.c1.where");
		executeSql = Outside.service(this,"gus.jdbc.mysql.perform.sqlexecute");
		findPrimaryKey = Outside.service(this,"gus.jdbc.mysql.perform.table.findprimarykey.strict");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=3) throw new Exception("Wrong data number: "+o.length);
		
		Connection cx = (Connection) o[0];
		String path = (String) o[1];
		String where = (String) o[2];
		
		String idCol = (String) findPrimaryKey.t(new Object[]{cx,path});
		String sql = (String) buildSql.t(new String[]{path,idCol,where});
		return executeSql.t(new Object[]{cx,sql});
	}
}
