package gus06.entity.gus.sys.script1.access.context.pool.latest;

import gus06.framework.*;
import java.util.Map;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150906";}
	
	
	private Service getCurrent;
	private Service getPool;

	public EntityImpl() throws Exception
	{
		getCurrent = Outside.service(this,"gus.sys.script1.access.context.execution.current");
		getPool = Outside.service(this,"gus.sys.script1.access.tag.stack1.pool1");
	}
	

	public Object t(Object obj) throws Exception
	{
		Map context = (Map) obj;
		Map currentTag = (Map) getCurrent.t(context);
		Map pool = (Map) getPool.t(currentTag);
		
		return pool;
	}
}
