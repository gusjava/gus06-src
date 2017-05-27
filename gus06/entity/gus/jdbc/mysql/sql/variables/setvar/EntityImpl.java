package gus06.entity.gus.jdbc.mysql.sql.variables.setvar;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20170129";}

	
	public Object t(Object obj) throws Exception
	{
		String[] o = (String[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		String key = o[0];
		String value = o[1];
		
		return "set @@global."+key+"="+value;
	}
}
