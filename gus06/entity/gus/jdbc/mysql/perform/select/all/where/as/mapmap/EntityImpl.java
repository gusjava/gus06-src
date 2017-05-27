package gus06.entity.gus.jdbc.mysql.perform.select.all.where.as.mapmap;

import gus06.framework.*;
import java.sql.ResultSet;
import java.sql.Connection;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20161007";}


	private Service perform;
	private Service findPrimaryKey;
	private Service rsTo;


	public EntityImpl() throws Exception
	{
		perform = Outside.service(this,"gus.jdbc.mysql.perform.select.all.where");
		findPrimaryKey = Outside.service(this,"gus.jdbc.mysql.perform.table.findprimarykey.strict");
		rsTo = Outside.service(this,"gus.jdbc.resultset.toobjectmapmap");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=3) throw new Exception("Wrong data number: "+o.length);
		
		Connection cx = (Connection) o[0];
		String path = (String) o[1];
		
		ResultSet rs = (ResultSet) perform.t(obj);
		String idCol = (String) findPrimaryKey.t(new Object[]{cx,path});
		return rsTo.t(new Object[]{rs,idCol});
	}
}
