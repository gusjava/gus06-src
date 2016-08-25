package gus06.entity.gus.jdbc.resultset.toobjectmaplist;

import gus06.framework.*;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160228";}
	


	public Object t(Object obj) throws Exception
	{
		ResultSet rs = (ResultSet) obj;
		ResultSetMetaData rsmd = rs.getMetaData();
		int count = rsmd.getColumnCount();
		
		ArrayList list = new ArrayList();
		while(rs.next())
		{
			Map map = new HashMap();
			for(int i=0;i<count;i++)
			{
				String col = rsmd.getColumnName(i+1);
				Object value = rs.getObject(i+1);
				map.put(col,value);
			}
			list.add(map);
		}
		
		rs.close();
		return list;
	}
}
