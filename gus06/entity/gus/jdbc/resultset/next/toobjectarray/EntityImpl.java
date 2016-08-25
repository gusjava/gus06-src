package gus06.entity.gus.jdbc.resultset.next.toobjectarray;

import java.sql.ResultSet;
import gus06.framework.*;
import java.util.Map;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160228";}


	private Service getArray;

	public EntityImpl() throws Exception
	{getArray = Outside.service(this,"gus.jdbc.resultset.get.objectarray");}


	public Object t(Object obj) throws Exception
	{
		ResultSet rs = (ResultSet) obj;
		if(!rs.next()) {rs.close();return null;}
		
		Object[] array = (Object[]) getArray.t(rs);
		rs.close();
		return array;
	}
}
