package gus06.entity.gus.jdbc.mysql.showgrants;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.Statement;
import gus06.framework.*;

public class EntityImpl implements Entity, T, F {

	public String creationDate() {return "20150613";}


	public static final String SQL = "SHOW GRANTS";
	


	public Object t(Object obj) throws Exception
	{
		if(obj==null) return null;
		
		Connection cx = (Connection) obj;
		DatabaseMetaData dbmd = cx.getMetaData();
		String user = dbmd.getUserName();
		
		Statement st = cx.createStatement();
		ResultSet rs = st.executeQuery(SQL);
		
		if(!rs.next())
		throw new Exception("SHOW GRANTS sql query did not return");
		
		String line = rs.getString(1).toLowerCase();
		boolean s = line.startsWith("grant all privileges on *.* to '");
		
		st.close();
		
		if(s) return user+"*"; 
		return user;
	}
	
	
	
	
	
	public boolean f(Object obj) throws Exception
	{
		if(obj==null) return false;
		
		Connection cx = (Connection) obj;
		Statement st = cx.createStatement();
		ResultSet rs = st.executeQuery(SQL);
		
		if(!rs.next())
		throw new Exception("SHOW GRANTS sql query did not return");
		
		String line = rs.getString(1).toLowerCase();
		return line.startsWith("grant all privileges on *.* to '");
	}
}
