package gus06.entity.gus.string.transform.wrap.qr5;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160502";}


	
	
	public Object t(Object obj) throws Exception
	{return format((String) obj);}
	
	
	private String format(String s)
	{
		if(s.startsWith("[") && s.endsWith("]"))
			return s.substring(1,s.length()-1);
		return s;
	}
}
