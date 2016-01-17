package gus06.entity.gus.sys.script1.access.pool1.blocks;

import gus06.framework.*;
import java.util.Map;

public class EntityImpl implements Entity, T {
	
	public String creationDate() {return "20151103";}
	
	public static final String C_BLOCKS = "blocks";


	private Service buildMap;


	public EntityImpl() throws Exception
	{buildMap = Outside.service(this,"gus.map.map1");}


	
	public Object t(Object obj) throws Exception
	{
		Map pool = (Map) obj;
		
		if(!pool.containsKey(C_BLOCKS))
			pool.put(C_BLOCKS,buildMap.t(C_BLOCKS));
		 
		Map blocks = (Map) pool.get(C_BLOCKS);
		return blocks;
	}
}
