package gus06.entity.gus.jdbc.mysql.sql.table.describe;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150624";}


	
	private Service format;
	
	public EntityImpl() throws Exception
	{format = Outside.service(this,"gus.jdbc.mysql.format.sql.name");}



	public Object t(Object obj) throws Exception
	{
		String path = (String) obj;
		return "DESCRIBE "+format(path);
	}
	
	private String format(String s) throws Exception
	{return (String) format.t(s);}
}
