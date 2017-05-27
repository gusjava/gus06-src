package gus06.entity.gus.jdbc.mysql.sql.info.fk.full.table;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20170322";}
	
	public static final String PATH = "information_schema.key_column_usage";
	public static final String COL_DB = "table_schema";
	public static final String COL_TABLE = "table_name";
	

	private Service format;
	
	public EntityImpl() throws Exception
	{format = Outside.service(this,"gus.jdbc.mysql.format.sql.value");}
	
	
	
	public Object t(Object obj) throws Exception
	{
		String[] t = toArray(obj);
		if(t.length!=2) throw new Exception("Wrong data number: "+t.length);
		
		String dbName = t[0];
		String tableName = t[1];
		
		return "SELECT * FROM "+PATH+
			" WHERE "+COL_DB+" = "+format(dbName)+
			" AND "+COL_TABLE+" = "+format(tableName)+
			" AND referenced_table_name IS NOT NULL";
	}

	private String format(String s) throws Exception
	{return (String) format.t(s);}
	
	
	
	
	private String[] toArray(Object obj) throws Exception
	{
		if(obj instanceof String[]) return (String[]) obj;
		if(obj instanceof String) return ((String) obj).split("\\.");
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
}
