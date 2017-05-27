package gus06.entity.gus.jdbc.mysql.sql.variables.setvar.maxallowedpacket;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150809";}
	
	
	private Service format;

	public EntityImpl() throws Exception
	{format = Outside.service(this,"gus.jdbc.mysql.format.sql.value");}

	
	public Object t(Object obj) throws Exception
	{
		String value = (String) obj;
		return "set @@global.max_allowed_packet="+format(value);
	}

	private String format(String s) throws Exception
	{return (String) format.t(s);}
}
