package gus06.entity.gus.jdbc.mysql.sql.user.setpwd.localroot;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150624";}



	public Object t(Object obj) throws Exception
	{		
		String pwd = (String) obj;
		return "SET PASSWORD FOR 'root'@'localhost' = PASSWORD('"+pwd+"')";
	}
}