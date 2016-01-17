package gus06.entity.gus.string.split.method1;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150526";}
	
	public Object t(Object obj) throws Exception
	{
		String s = (String) obj;
		return s.split(" +");
	}
}
