package gus06.entity.gus.string.transform.normalize.diacritics.camelcase;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160203";}
	
	public Object t(Object obj) throws Exception
	{return DIACRITICS_CAMEL.normalize((String)obj);}
}
