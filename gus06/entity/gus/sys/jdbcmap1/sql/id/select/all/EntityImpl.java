package gus06.entity.gus.sys.jdbcmap1.sql.id.select.all;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150804";}

	public final static String PRIMARY_KEY = "ID";
	
	
	private Service formatName;
	
	public EntityImpl() throws Exception
	{
		formatName = Outside.service(this,"gus.jdbc.mysql.format.sql.name");
	}
	
	

	public Object t(Object obj) throws Exception
	{
		String path = (String) obj;
		return "SELECT "+PRIMARY_KEY+" FROM "+formatName(path);
	}
	
	private String formatName(String name) throws Exception
	{return (String) formatName.t(name);}
}
