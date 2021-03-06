package gus06.entity.gus.jdbc.mysql.perform.select.all.limit.as.maplist;

import gus06.framework.*;
import java.sql.ResultSet;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20161008";}


	private Service perform;
	private Service rsTo;


	public EntityImpl() throws Exception
	{
		perform = Outside.service(this,"gus.jdbc.mysql.perform.select.all.limit");
		rsTo = Outside.service(this,"gus.jdbc.resultset.toobjectmaplist");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		ResultSet rs = (ResultSet) perform.t(obj);
		return rsTo.t(rs);
	}
}
