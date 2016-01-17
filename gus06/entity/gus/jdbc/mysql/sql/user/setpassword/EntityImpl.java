package gus06.entity.gus.jdbc.mysql.sql.user.setpwd;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150624";}



	public Object t(Object obj) throws Exception
	{
		String[] o = (String[]) obj;
		if(o.length!=3) throw new Exception("Wrong data number: "+o.length);
		
		String user = o[0];
		String host = o[1];
		String pwd = o[2];
		
		return "SET PASSWORD FOR "+userHost(user,host)+" = PASSWORD('"+pwd+"')";
	}
	
	private String userHost(String user, String host)
	{
		if(user==null || user.equals("")) user = "%";
		if(host==null || host.equals("")) host = "%";
		return "'"+user+"'@'"+host+"'";
	}
}
