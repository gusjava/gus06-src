package gus06.entity.gus.jdbc.resultset.toobjectarraylist;

import gus06.framework.*;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150623";}
	


	public Object t(Object obj) throws Exception
	{
		ResultSet rs = (ResultSet) obj;
		ResultSetMetaData rsmd = rs.getMetaData();
		int count = rsmd.getColumnCount();
		
		ArrayList list = new ArrayList();
		while(rs.next())
		{
			Object[] row = new Object[count];
			for(int i=0;i<count;i++)
			row[i] = rs.getObject(i+1);
			
			list.add(row);
		}
		
		rs.close();
		return list;
	}
}
