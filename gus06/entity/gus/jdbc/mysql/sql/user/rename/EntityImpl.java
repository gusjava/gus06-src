package gus06.entity.gus.jdbc.mysql.sql.user.rename;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150624";}



	public Object t(Object obj) throws Exception
	{
		String[] o = (String[]) obj;
		if(o.length!=4) throw new Exception("Wrong data number: "+o.length);
		
		String user1 = o[0];
		String host1 = o[1];
		String user2 = o[2];
		String host2 = o[3];
		
		return "RENAME USER "+userHost(user1,host1)+" TO "+userHost(user2,host2);
	}
	
	private String userHost(String user, String host)
	{
		if(user==null || user.equals("")) user = "%";
		if(host==null || host.equals("")) host = "%";
		return "'"+user+"'@'"+host+"'";
	}
}
