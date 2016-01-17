package gus06.entity.gus.jdbc.mysql.sql.variables.maxallowedpacket;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150809";}

	
	public Object t(Object obj) throws Exception
	{
		String value = (String) obj;
		return "set @@global.max_allowed_packet="+value;
	}
}
