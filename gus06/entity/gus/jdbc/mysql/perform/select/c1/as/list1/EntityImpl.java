package gus06.entity.gus.jdbc.mysql.perform.select.c1.as.list1;

import gus06.framework.*;
import java.sql.ResultSet;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160503";}


	private Service perform;
	private Service rsToList;


	public EntityImpl() throws Exception
	{
		perform = Outside.service(this,"gus.jdbc.mysql.perform.select.c1");
		rsToList = Outside.service(this,"gus.jdbc.resultset.toobjectlist1");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		ResultSet rs = (ResultSet) perform.t(obj);
		return rsToList.t(rs);
	}
}
