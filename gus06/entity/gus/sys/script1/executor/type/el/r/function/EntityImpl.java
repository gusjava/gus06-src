package gus06.entity.gus.sys.script1.executor.type.el.r.function;

import gus06.framework.*;
import java.util.Map;
import java.util.HashMap;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151103";}

	
	private Service getParams;
	private Service evalAsString;
	private Service getPool;
	private Service getBlocks;


	public EntityImpl() throws Exception
	{
		getParams = Outside.service(this,"gus.sys.script1.access.tag.params1");
		evalAsString = Outside.service(this,"gus.sys.script1.context.evaluate.string1");
		getPool = Outside.service(this,"gus.sys.script1.access.context.pool1.latest");
		getBlocks = Outside.service(this,"gus.sys.script1.access.pool1.blocks");
	}
	
	
	
	
	public Object t(Object obj) throws Exception
	{return new Executor((Map) obj);}
	
	
	
	
	private class Executor implements P
	{
		private Map tag;
		public Executor(Map tag) {this.tag = tag;}
		
		public void p(Object obj) throws Exception
		{
			Map context = (Map) obj;
			
			String params = (String) getParams.t(tag);
			String blockName = (String) evalAsString.t(new Object[]{context,params});
			
			Map pool = (Map) getPool.t(context);
			Map blocks = (Map) getBlocks.t(pool);
			
			blocks.put(blockName,tag);
		}
	}
}
