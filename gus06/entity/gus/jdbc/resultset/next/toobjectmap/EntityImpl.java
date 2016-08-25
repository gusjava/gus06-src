package gus06.entity.gus.jdbc.resultset.next.toobjectmap;

import java.sql.ResultSet;
import gus06.framework.*;
import java.util.Map;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150625";}


	private Service getMap;

	public EntityImpl() throws Exception
	{getMap = Outside.service(this,"gus.jdbc.resultset.get.objectmap");}


	public Object t(Object obj) throws Exception
	{
		ResultSet rs = (ResultSet) obj;
		if(!rs.next()) {rs.close();return null;}
		
		Map map = (Map) getMap.t(rs);
		rs.close();
		return map;
	}
}
