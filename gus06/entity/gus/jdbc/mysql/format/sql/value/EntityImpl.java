package gus06.entity.gus.jdbc.mysql.format.sql.value;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20141009";}


	public final static int LIMITSIZE = 65535;
	
	
	public Object t(Object obj) throws Exception
	{
		String value = (String) obj;
		if(value.length()>LIMITSIZE) value = value.substring(0,LIMITSIZE);
		return "'"+value.replace("\\","\\\\").replace("'","\\'")+"'";
	}
}
