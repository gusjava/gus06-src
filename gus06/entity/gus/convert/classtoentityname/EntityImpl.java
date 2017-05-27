package gus06.entity.gus.convert.classtoentityname;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160507";}

	
	public Object t(Object obj) throws Exception
	{
		String name = toName(obj);
		if(!name.endsWith(".EntityImpl")) return null;
		if(!name.startsWith("gus06.entity.")) return null;
		
		return name.substring(13,name.length()-11);
	}
	
	
	private String toName(Object obj) throws Exception
	{
		if(obj instanceof Class) return ((Class) obj).getName();
		if(obj instanceof String) return (String) obj;
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
}
