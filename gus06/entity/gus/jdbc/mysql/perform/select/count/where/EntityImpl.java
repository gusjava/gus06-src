package gus06.entity.gus.jdbc.mysql.perform.select.count.where;

import gus06.framework.*;
import java.sql.Connection;
import java.sql.ResultSet;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20161008";}


	private Service buildSql;
	private Service executeSql;
	private Service nextToInt;


	public EntityImpl() throws Exception
	{
		buildSql = Outside.service(this,"gus.jdbc.mysql.sql.select.count.where");
		executeSql = Outside.service(this,"gus.jdbc.mysql.perform.sqlexecute");
		nextToInt = Outside.service(this,"gus.jdbc.resultset.next.tointeger");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=3) throw new Exception("Wrong data number: "+o.length);
		
		Connection cx = (Connection) o[0];
		String path = (String) o[1];
		String where = (String) o[2];
		
		String sql = (String) buildSql.t(new String[]{path,where});
		ResultSet rs = (ResultSet) executeSql.t(new Object[]{cx,sql});
		return nextToInt.t(rs);
	}
}
