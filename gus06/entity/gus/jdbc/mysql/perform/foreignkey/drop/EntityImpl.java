package gus06.entity.gus.jdbc.mysql.perform.foreignkey.drop;

import gus06.framework.*;
import java.sql.Connection;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20170321";}


	private Service buildSql;
	private Service executeSql;
	private Service protectedPath;

	public EntityImpl() throws Exception
	{
		buildSql = Outside.service(this,"gus.jdbc.mysql.sql.foreignkey.drop");
		executeSql = Outside.service(this,"gus.jdbc.mysql.perform.sqlexecute");
		protectedPath = Outside.service(this,"gus.jdbc.mysql.check.protectedpath");
	}
	
	
	public void p(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=3) throw new Exception("Wrong data number: "+o.length);
		
		Connection cx = (Connection) o[0];
		String path = (String) o[1];
		String fkName = (String) o[2];
		
		if(protectedPath.f(path)) throw new Exception("Attempt to alter table: "+path);
		
		String sql = (String) buildSql.t(new String[]{path,fkName});
		executeSql.p(new Object[]{cx,sql});
	}
}