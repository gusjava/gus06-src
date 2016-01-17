package gus06.entity.gus.jdbc.mysql.perform.db.getlength;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Set;
import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150623";}


	private Service buildSql;
	private Service rsToString;
	

	public EntityImpl() throws Exception
	{
		buildSql = Outside.service(this,"gus.jdbc.mysql.sql.info.getlength.db");
		rsToString = Outside.service(this,"gus.jdbc.resultset.next.tostring");
	}
	


	public Object t(Object obj) throws Exception
	{
		if(obj==null) return null;
		
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		Connection cx = (Connection) o[0];
		String dbName = (String) o[1];
		
		String sql = (String) buildSql.t(dbName);
		
		try
		{
			Statement st = cx.createStatement();
			ResultSet rs = st.executeQuery(sql);
			return rsToString.t(rs);
		}
		catch(Exception e)
		{
			String message = "Failed to execute sql: "+sql;
			throw new Exception(message,e);
		}
	}
}
