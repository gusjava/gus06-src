package gus06.entity.gus.jdbc.mysql.perform.user.rename;

import java.sql.Connection;
import gus06.framework.*;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20150624";}


	private Service buildSql;
	private Service executeSql;
	
	public EntityImpl() throws Exception
	{
		buildSql = Outside.service(this,"gus.jdbc.mysql.sql.user.rename");
		executeSql = Outside.service(this,"gus.jdbc.mysql.perform.sqlexecute");
	}



	public void p(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=5) throw new Exception("Wrong data number: "+o.length);
		
		Connection cx = (Connection) o[0];
		String user1 = (String) o[1];
		String host1 = (String) o[2];
		String user2 = (String) o[3];
		String host2 = (String) o[4];
		
		String sql = (String) buildSql.t(new String[]{user1,host1,user2,host2});
		executeSql.p(new Object[]{cx,sql});
	}
}
