package gus06.entity.gus.jdbc.mysql.sql.info.fk.full.db;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20170322";}
	
	public static final String PATH = "information_schema.key_column_usage";
	public static final String COL_DB = "table_schema";
	


	private Service format;
	
	public EntityImpl() throws Exception
	{format = Outside.service(this,"gus.jdbc.mysql.format.sql.value");}
	
	
	
	public Object t(Object obj) throws Exception
	{
		String dbName = (String) obj;
		return "SELECT * FROM "+PATH+" WHERE "+COL_DB+" = "+format(dbName)+" AND referenced_table_name IS NOT NULL";
	}

	private String format(String s) throws Exception
	{return (String) format.t(s);}
}
