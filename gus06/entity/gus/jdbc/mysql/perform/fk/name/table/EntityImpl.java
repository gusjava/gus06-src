package gus06.entity.gus.jdbc.mysql.perform.fk.name.table;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20170321";}


	private Service buildSql;
	private Service rsToList;
	

	public EntityImpl() throws Exception
	{
		buildSql = Outside.service(this,"gus.jdbc.mysql.sql.info.fk.name.table");
		rsToList = Outside.service(this,"gus.jdbc.resultset.tostringlist");
	}
	


	public Object t(Object obj) throws Exception
	{
		if(obj==null) return null;
		
		Object[] o = (Object[]) obj;
		if(o.length!=3) throw new Exception("Wrong data number: "+o.length);
		
		Connection cx = (Connection) o[0];
		String dbName = (String) o[1];
		String tableName = (String) o[2];
		
		String sql = (String) buildSql.t(new String[]{dbName,tableName});
		
		try
		{
			Statement st = cx.createStatement();
			ResultSet rs = st.executeQuery(sql);
			return rsToList.t(rs);
		}
		catch(Exception e)
		{
			String message = "Failed to execute sql: "+sql;
			throw new Exception(message,e);
		}
	}
}
