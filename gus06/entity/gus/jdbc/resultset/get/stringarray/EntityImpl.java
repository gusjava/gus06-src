package gus06.entity.gus.jdbc.resultset.get.stringarray;

import java.sql.ResultSet;
import gus06.framework.*;
import java.util.HashMap;
import java.sql.ResultSetMetaData;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151115";}



	public Object t(Object obj) throws Exception
	{
		ResultSet rs = (ResultSet) obj;
		ResultSetMetaData rsmd = rs.getMetaData();
		int count = rsmd.getColumnCount();
		
		String[] array = new String[count];
		for(int i=0;i<count;i++)
		array[i] = rs.getString(i+1);
		
		return array;
	}
}
