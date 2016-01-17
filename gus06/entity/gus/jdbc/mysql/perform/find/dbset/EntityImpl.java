package gus06.entity.gus.jdbc.mysql.perform.find.dbset;

import gus06.framework.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20141006";}

	public static final String SQL = "SHOW DATABASES";
	
	
	private Service rsToSet;
	
	public EntityImpl() throws Exception
	{rsToSet = Outside.service(this,"gus.jdbc.resultset.tostringset");}

	
	
	public Object t(Object obj) throws Exception
	{
		if(obj==null) return null;

		Connection cx = (Connection) obj;
		Statement st = cx.createStatement();
		ResultSet rs = st.executeQuery(SQL);
		return rsToSet.t(rs);
	}
}
