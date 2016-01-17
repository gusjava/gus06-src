package gus06.entity.gus.sys.script1.access.context.pool1.all;

import gus06.framework.*;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150905";}
	
	public static final String POOL = "pool";
	

	private Service stackList;
	
	public EntityImpl() throws Exception
	{stackList = Outside.service(this,"gus.sys.script1.access.context.stacklist");}


	
	public Object t(Object obj) throws Exception
	{
		Map context = (Map) obj;
		List stacks = (List) stackList.t(context);
		List pools = new ArrayList();
		
		for(Object stack:stacks) pools.add(getPool((Map)stack));
		return pools;
	}
	
	private Map getPool(Map map) throws Exception
	{
		if(!map.containsKey(POOL)) throw new Exception("Pool not found inside map");
		return (Map) map.get(POOL);
	}
}
