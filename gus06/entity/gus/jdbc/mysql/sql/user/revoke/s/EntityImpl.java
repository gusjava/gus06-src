package gus06.entity.gus.jdbc.mysql.sql.user.revoke.s;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150624";}



	private Service format;

	public EntityImpl() throws Exception
	{format = Outside.service(this,"gus.jdbc.mysql.format.sql.sequence");}



	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=3) throw new Exception("Wrong data number: "+o.length);
		
		Object priv = o[0];
		String user = (String) o[1];
		String host = (String) o[2];
		
		return "REVOKE "+format(priv)+" ON *.* FROM "+userHost(user,host);
	}
	
	private String format(Object priv) throws Exception
	{return (String) format.t(priv);}
	
	
	private String userHost(String user, String host)
	{
		if(user==null || user.equals("")) user = "%";
		if(host==null || host.equals("")) host = "%";
		return "'"+user+"'@'"+host+"'";
	}
}
