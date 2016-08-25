package gus06.entity.gus.jdbc.mysql.perform.select.c1c2;

import gus06.framework.*;
import java.sql.Connection;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160503";}


	private Service buildSql;
	private Service executeSql;


	public EntityImpl() throws Exception
	{
		buildSql = Outside.service(this,"gus.jdbc.mysql.sql.select.c1c2");
		executeSql = Outside.service(this,"gus.jdbc.mysql.perform.sqlexecute");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=4) throw new Exception("Wrong data number: "+o.length);
		
		Connection cx = (Connection) o[0];
		String path = (String) o[1];
		String c1 = (String) o[2];
		String c2 = (String) o[3];
		
		String sql = (String) buildSql.t(new String[]{path,c1,c2});
		return executeSql.t(new Object[]{cx,sql});
	}
}
