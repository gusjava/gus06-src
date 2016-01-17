package gus06.entity.gus.sys.script1.context.builder1.app;

import gus06.framework.*;
import java.util.Map;
import java.util.HashMap;

public class EntityImpl implements Entity, G {

	public String creationDate() {return "20151122";}


	private Service buildMap;
	
	private Map main;
	private Map map0;
	
	public EntityImpl() throws Exception
	{
		buildMap = Outside.service(this,"gus.map.map1");
		main = (Map) Outside.resource(this,"main");
		
		map0 = new HashMap();
		
		map0.put("sysprop",System.getProperties());
		map0.put("sysenv",System.getenv());
		map0.put("sysout",System.out);
		map0.put("syserr",System.err);
		map0.put("main",main);
	}
	
	
	public Object g() throws Exception
	{
		Map map = (Map) buildMap.t("app");
		map.putAll(map0);
		return map;
	}
}
