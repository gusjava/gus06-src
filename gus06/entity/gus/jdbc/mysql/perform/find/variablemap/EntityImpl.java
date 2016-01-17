package gus06.entity.gus.jdbc.mysql.perform.find.variablemap;

import gus06.framework.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150625";}

	public static final String SQL = "SHOW GLOBAL VARIABLES";
	
	
	private Service rsToMap;
	
	public EntityImpl() throws Exception
	{rsToMap = Outside.service(this,"gus.jdbc.resultset.tostringmap");}

	
	
	public Object t(Object obj) throws Exception
	{
		if(obj==null) return null;

		Connection cx = (Connection) obj;
		Statement st = cx.createStatement();
		ResultSet rs = st.executeQuery(SQL);
		return rsToMap.t(rs);
	}
}
