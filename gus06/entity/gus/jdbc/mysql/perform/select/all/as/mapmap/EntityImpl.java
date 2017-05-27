package gus06.entity.gus.jdbc.mysql.perform.select.all.as.mapmap;

import gus06.framework.*;
import java.sql.ResultSet;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160503";}


	private Service perform;
	private Service findPrimaryKey;
	private Service rsTo;


	public EntityImpl() throws Exception
	{
		perform = Outside.service(this,"gus.jdbc.mysql.perform.select.all");
		findPrimaryKey = Outside.service(this,"gus.jdbc.mysql.perform.table.findprimarykey.strict");
		rsTo = Outside.service(this,"gus.jdbc.resultset.toobjectmapmap");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		ResultSet rs = (ResultSet) perform.t(obj);
		String idCol = (String) findPrimaryKey.t(obj);
		return rsTo.t(new Object[]{rs,idCol});
	}
}
