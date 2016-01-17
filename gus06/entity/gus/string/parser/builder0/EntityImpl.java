package gus06.entity.gus.string.parser.builder0;

import gus06.framework.*;
import java.util.Map;

public class EntityImpl implements Entity, T, R {

	public String creationDate() {return "20140818";}
	

	private Service buildParser;
	private Service findMap;
	
	public EntityImpl() throws Exception
	{
		buildParser = Outside.service(this,"gus.string.parser.builder");
		findMap = Outside.service(this,"gus.app.inside.parser");
	}
	
	
	public Object t(Object obj) throws Exception
	{return r((String) obj);}
	
	
	
	public Object r(String key) throws Exception
	{
		Map map = (Map) findMap.r(key);
		return buildParser.t(map);
	}	
}
