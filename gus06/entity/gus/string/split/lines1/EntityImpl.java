package gus06.entity.gus.string.split.lines1;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160604";}
	

	
	public Object t(Object obj) throws Exception
	{
		String s = (String) obj;
		return s.split("[\n\r]+");
	}
}
