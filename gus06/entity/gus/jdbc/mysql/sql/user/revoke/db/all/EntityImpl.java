package gus06.entity.gus.jdbc.mysql.sql.user.revoke.db.all;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150624";}


	
	public Object t(Object obj) throws Exception
	{
		String[] o = (String[]) obj;
		if(o.length!=3) throw new Exception("Wrong data number: "+o.length);
		
		String database = o[0];
		String user = o[1];
		String host = o[2];
		
		return "REVOKE ALL ON "+database+".* FROM "+userHost(user,host);
	}
	
	private String userHost(String user, String host)
	{
		if(user==null || user.equals("")) user = "%";
		if(host==null || host.equals("")) host = "%";
		return "'"+user+"'@'"+host+"'";
	}
}
