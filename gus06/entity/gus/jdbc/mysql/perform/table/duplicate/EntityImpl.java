package gus06.entity.gus.jdbc.mysql.perform.table.duplicate;

import gus06.framework.*;
import java.sql.Connection;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20150624";}



	private Service buildSql;
	private Service executeSql;
	
	public EntityImpl() throws Exception
	{
		buildSql = Outside.service(this,"gus.jdbc.mysql.sql.table.duplicate");
		executeSql = Outside.service(this,"gus.jdbc.mysql.perform.sqlexecute");
	}
	

	public void p(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=3) throw new Exception("Wrong data number: "+o.length);
		
		Connection cx = (Connection) o[0];
		String path1 = (String) o[1];
		String path2 = (String) o[2];
		
		String sql = (String) buildSql.t(new String[]{path1,path2});
		executeSql.p(new Object[]{cx,sql});
	}
}
