package gus06.entity.gus.outside.call;

import gus06.framework.*;

public class EntityImpl implements Entity, T, R {

	public String creationDate() {return "20141007";}


	public Object t(Object obj) throws Exception
	{return r((String) obj);}
	
	
	public Object r(String key) throws Exception
	{return Outside.resource(this,key);}
}
