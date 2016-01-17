package gus06.entity.gus.jdbc.mysql.perform.user.revoke.s;

import java.sql.Connection;
import gus06.framework.*;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20150624";}

	
	private Service buildSql;
	private Service executeSql;
	
	public EntityImpl() throws Exception
	{
		buildSql = Outside.service(this,"gus.jdbc.mysql.sql.user.revoke.s");
		executeSql = Outside.service(this,"gus.jdbc.mysql.perform.sqlexecute");
	}
	

	public void p(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=4) throw new Exception("Wrong data number: "+o.length);
		
		Connection cx = (Connection) o[0];
		Object priv = o[1];
		Object user = o[2];
		Object host = o[3];
		
		String sql = (String) buildSql.t(new Object[]{priv,user,host});
		executeSql.p(new Object[]{cx,sql});
	}
}
