package gus06.entity.gus.jdbc.mysql.perform.select.all.id.as.map;

import gus06.framework.*;
import java.sql.ResultSet;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20170421";}


	private Service perform;
	private Service rsTo;


	public EntityImpl() throws Exception
	{
		perform = Outside.service(this,"gus.jdbc.mysql.perform.select.all.id");
		rsTo = Outside.service(this,"gus.jdbc.resultset.next.toobjectmap");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		ResultSet rs = (ResultSet) perform.t(obj);
		return rsTo.t(rs);
	}
}
