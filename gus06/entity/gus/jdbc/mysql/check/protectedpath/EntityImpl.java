package gus06.entity.gus.jdbc.mysql.check.protectedpath;

import gus06.framework.*;

public class EntityImpl implements Entity, F {

	public String creationDate() {return "20160409";}

	
	
	public boolean f(Object obj) throws Exception
	{
		String path = (String) obj;
		
		if(path.equals("mysql")) return true;
		if(path.equals("information_schema"))  return true;
		if(path.equals("performance_schema"))  return true;
		
		if(path.contains("."))
		{
			if(path.startsWith("mysql.")) return true;
			if(path.startsWith("information_schema."))  return true;
			if(path.startsWith("performance_schema."))  return true;
		}
		
		return false;
	}
}