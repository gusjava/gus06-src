package gus06.entity.gus.app.prop.get;

import gus06.framework.*;
import java.util.Map;

public class EntityImpl implements Entity, T, R {

	public String creationDate() {return "20140909";}


	private Map prop;
	
	public EntityImpl() throws Exception
	{prop = (Map) Outside.resource(this,"prop");}
	
	
	public Object r(String key) throws Exception
	{return prop.containsKey(key)?prop.get(key):null;}
	
	
	public Object t(Object obj) throws Exception
	{return r((String) obj);}
}
