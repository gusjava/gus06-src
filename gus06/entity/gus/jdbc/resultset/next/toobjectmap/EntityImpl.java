package gus06.entity.gus.jdbc.resultset.next.toobjectmap;

import java.sql.ResultSet;
import gus06.framework.*;
import java.util.HashMap;
import java.sql.ResultSetMetaData;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150625";}



	public Object t(Object obj) throws Exception
	{
		ResultSet rs = (ResultSet) obj;
		if(!rs.next()) {rs.close();return null;}
		
		ResultSetMetaData rsmd = rs.getMetaData();
		int count = rsmd.getColumnCount();
		
		HashMap map = new HashMap();
		for(int i=0;i<count;i++)
		{
			String col = rsmd.getColumnName(i+1);
			Object value = rs.getObject(i+1);
			map.put(col,value);
		}
		rs.close();
		return map;
	}
}
