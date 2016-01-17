package gus06.entity.gus.jdbc.mysql.sql.info.selecttable.db;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150622";}
	
	public static final String PATH = "information_schema.tables";
	public static final String COL_DB = "table_schema";
	public static final String COL_TABLE = "table_name";
	

	private Service format;
	
	public EntityImpl() throws Exception
	{format = Outside.service(this,"gus.jdbc.mysql.format.sql.value");}
	
	
	
	
	public Object t(Object obj) throws Exception
	{
		String dbName = (String) obj;
		return "SELECT "+COL_TABLE+" FROM "+PATH+" WHERE "+COL_DB+" = "+format(dbName);
	}

	private String format(String s) throws Exception
	{return (String) format.t(s);}
}
