package gus06.entity.gus.string.transform.normalize.diacritics;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20141023";}

	public Object t(Object obj) throws Exception
	{return DIACRITICS.normalize((String)obj);}
}
