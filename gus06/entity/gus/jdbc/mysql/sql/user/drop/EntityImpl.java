package gus06.entity.gus.jdbc.mysql.sql.user.drop;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150624";}


	private Service formatUser;

	public EntityImpl() throws Exception
	{
		formatUser = Outside.service(this,"gus.jdbc.mysql.format.sql.username");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		String[] o = (String[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		String user = o[0];
		String host = o[1];
		
		return "DROP USER "+userHost(user,host);
	}
	
	
	private String userHost(String user, String host) throws Exception
	{
		return (String) formatUser.t(new String[]{user,host});
	}
}