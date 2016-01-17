package gus06.entity.gus.jdbc.mysql.sql.user.grant.table;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150624";}


	private Service format;

	public EntityImpl() throws Exception
	{format = Outside.service(this,"gus.jdbc.mysql.format.sql.sequence");}



	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=5) throw new Exception("Wrong data number: "+o.length);
		
		Object priv = o[0];
		String database = (String) o[1];
		String table = (String) o[2];
		String user = (String) o[3];
		String host = (String) o[4];
		
		return "GRANT "+format(priv)+" ON "+database+"."+table+" TO "+userHost(user,host);
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
