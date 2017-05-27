package gus06.entity.gus.string.transform.normalize.whitespace;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160521";}
	
	
	public Object t(Object obj) throws Exception
	{
		String s = (String) obj;
		s = s.replaceAll("[ \t\f\n\r]+"," ");
		return s.trim();
	}
}
