package gus06.entity.gus.string.transform.normalize.whitespace;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160521";}
	
	
	public Object t(Object obj) throws Exception
	{
		String s = (String) obj;
		
		s = s.replaceAll("[\n\r]+","\n").replaceAll("[ \t\f]+"," ");
		
		if(s.startsWith(" ")) s = s.substring(1);
		if(s.endsWith(" ")) s = s.substring(0,s.length()-1);
		return s;
	}
}
