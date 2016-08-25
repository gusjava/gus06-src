package gus06.entity.gus.filter.string.haschar.punctuation;

import gus06.framework.*;

public class EntityImpl implements Entity, F {

	public String creationDate() {return "20150526";}

	public boolean f(Object obj) throws Exception
	{
		if(obj==null) return false;

		String str = (String) obj;
		return str.matches(".*\\p{Punct}.*");
	}
}