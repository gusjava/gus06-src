package gus06.entity.gus.jdbc.resultset.tostringset;

import java.sql.ResultSet;
import java.util.HashSet;
import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150622";}


	public Object t(Object obj) throws Exception
	{
		ResultSet rs = (ResultSet) obj;
		HashSet set = new HashSet();
		while(rs.next()) set.add(rs.getString(1));
		rs.close();
		return set;
	}
}
