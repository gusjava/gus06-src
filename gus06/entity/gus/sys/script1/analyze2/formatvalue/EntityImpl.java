package gus06.entity.gus.sys.script1.analyze2.formatvalue;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150906";}

	
	
	public Object t(Object obj) throws Exception
	{
		String value = (String) obj;
		value = value.trim();
		
		if(value.startsWith(">")) return "p "+value.substring(1);
		if(value.startsWith("*")) return "e "+value.substring(1);
		if(value.startsWith("!")) return "c "+value.substring(1);
		if(value.startsWith("$")) return "s "+value.substring(1);
		
		return value;
	}
}