package gus06.entity.gus.jdbc.mysql.perform.select.id1.as.list;

import gus06.framework.*;
import java.sql.ResultSet;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20170517";}


	private Service perform;
	private Service rsToList;


	public EntityImpl() throws Exception
	{
		perform = Outside.service(this,"gus.jdbc.mysql.perform.select.id1");
		rsToList = Outside.service(this,"gus.jdbc.resultset.toobjectlist");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		ResultSet rs = (ResultSet) perform.t(obj);
		return rsToList.t(rs);
	}
}
