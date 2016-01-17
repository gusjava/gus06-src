package gus06.entity.gus.jdbc.mysql.perform.db.create;

import gus06.framework.*;
import java.sql.Connection;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20141009";}


	private Service buildSql;
	private Service executeSql;


	public EntityImpl() throws Exception
	{
		buildSql = Outside.service(this,"gus.jdbc.mysql.sql.db.create");
		executeSql = Outside.service(this,"gus.jdbc.mysql.perform.sqlexecute");
	}
	
	
	public void p(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		Connection cx = (Connection) o[0];
		String dbName = (String) o[1];
		
		String sql = (String) buildSql.t(dbName);
		executeSql.p(new Object[]{cx,sql});
	}
}
