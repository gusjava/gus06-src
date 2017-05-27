package gus06.entity.gus.jdbc.mysql.perform.variables.show;

import gus06.framework.*;
import java.sql.Connection;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20170129";}

	public static final String SQL = "show variables";

	private Service executeSql;

	public EntityImpl() throws Exception
	{
		executeSql = Outside.service(this,"gus.jdbc.mysql.perform.sqlexecute");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		Connection cx = (Connection) obj;
		return executeSql.t(new Object[]{cx,SQL});
	}
}
