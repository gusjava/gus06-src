package gus06.entity.gus.sys.script1.access.context.search.block;

import gus06.framework.*;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151103";}


	private Service getBlocks;
	private Service allPools;
	
	public EntityImpl() throws Exception
	{
		getBlocks = Outside.service(this,"gus.sys.script1.access.pool1.blocks");
		allPools = Outside.service(this,"gus.sys.script1.access.context.pool1.all");
	}


	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		Map context = (Map) o[0];
		String blockName = (String) o[1];
		
		List pools = (List) allPools.t(context);
		
		int nb = pools.size();
		for(int i=0;i<nb;i++)
		{
			Map pool = (Map) pools.get(nb-1-i);
			Map block = getBlock(pool,blockName);
			if(block!=null) return block;
		}
		return null;
	}
	
	
	
	private Map getBlock(Map pool, String blockName) throws Exception
	{
		Map blocks = (Map) getBlocks.t(pool);
		if(!blocks.containsKey(blockName)) return null;
		return (Map) blocks.get(blockName);
	}
}
