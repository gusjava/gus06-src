package gus06.entity.gus.jdbc.mysql.perform.select.all.ids.as.mapmap;

import gus06.framework.*;
import java.sql.ResultSet;
import java.sql.Connection;
import java.util.HashMap;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20170523";}

	public static final String ID = "id";

	private Service perform;
	private Service findPrimaryKey;
	private Service rsTo;


	public EntityImpl() throws Exception
	{
		perform = Outside.service(this,"gus.jdbc.mysql.perform.select.all.ids");
		rsTo = Outside.service(this,"gus.jdbc.resultset.toobjectmapmap");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		ResultSet rs = (ResultSet) perform.t(obj);
		if(rs==null) return new HashMap();
		return rsTo.t(new Object[]{rs,ID});
	}
}
