package gus06.entity.gus.jdbc.mysql.sql.db.create;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20141009";}


	
	public Object t(Object obj) throws Exception
	{
		String name = (String) obj;
		return "CREATE DATABASE IF NOT EXISTS "+name+
			" DEFAULT CHARACTER SET utf8 DEFAULT COLLATE utf8_general_ci";
	}
}
