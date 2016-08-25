package gus06.entity.gus.string.transform.regexp.delimtoregex;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160324";}

	
	
	public Object t(Object obj) throws Exception
	{
		String delim = (String) obj;
		if(delim.length()!=2) throw new Exception("Invalid delim info: "+delim);
		
		char d1 = delim.charAt(0);
		char d2 = delim.charAt(1);
		
		return "\\"+d1+"[^\\"+d2+"]*\\"+d2;
	}
}
