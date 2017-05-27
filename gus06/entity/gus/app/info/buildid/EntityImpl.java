package gus06.entity.gus.app.info.buildid;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import gus06.framework.*;

public class EntityImpl implements Entity, G {

	public String creationDate() {return "20170411";}


	public static final String PROP_BUILDID = "jar.buildid";
	
	
	
	private Map prop;
	
	public EntityImpl() throws Exception
	{
		prop = (Map) Outside.resource(this,"prop");
	}
	
	
	public Object g() throws Exception
	{
		return get(PROP_BUILDID);
	}
	
	
	private String get(String key)
	{
		if(!prop.containsKey(key)) return "?";
		return (String) prop.get(key);
	}
}
