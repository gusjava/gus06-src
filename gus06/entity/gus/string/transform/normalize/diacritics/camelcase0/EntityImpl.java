package gus06.entity.gus.string.transform.normalize.diacritics.camelcase0;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160415";}
	
	public Object t(Object obj) throws Exception
	{return DIACRITICS_CAMEL0.normalize((String)obj);}
}
