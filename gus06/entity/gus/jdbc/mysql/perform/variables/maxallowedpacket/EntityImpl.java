package gus06.entity.gus.jdbc.mysql.perform.variables.maxallowedpacket;

import gus06.framework.*;
import java.sql.Connection;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20150809";}


	private Service buildSql;
	private Service executeSql;


	public EntityImpl() throws Exception
	{
		buildSql = Outside.service(this,"gus.jdbc.mysql.sql.variables.maxallowedpacket");
		executeSql = Outside.service(this,"gus.jdbc.mysql.perform.sqlexecute");
	}
	
	
	public void p(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		Connection cx = (Connection) o[0];
		String value = (String) o[1];
		
		String sql = (String) buildSql.t(value);
		executeSql.p(new Object[]{cx,sql});
	}
}
