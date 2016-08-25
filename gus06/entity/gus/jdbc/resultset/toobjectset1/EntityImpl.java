package gus06.entity.gus.jdbc.resultset.toobjectset1;

import java.sql.ResultSet;
import java.util.HashSet;
import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160503";}


	public Object t(Object obj) throws Exception
	{
		ResultSet rs = (ResultSet) obj;
		HashSet set = new HashSet();
		while(rs.next())
		{
			Object value = rs.getObject(1);
			if(set.contains(value)) throw new Exception("Duplicated value found: "+value);
			set.add(value);
		}
		rs.close();
		return set;
	}
}
