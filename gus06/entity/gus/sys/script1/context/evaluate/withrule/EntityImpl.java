package gus06.entity.gus.sys.script1.context.evaluate.withrule;

import gus06.framework.*;
import java.util.Map;
import java.util.List;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151120";}


	private Service retrievePool;
	private Service retrieveEvaluator;
	private Service retrieveOpMap;
	
	public EntityImpl() throws Exception
	{
		retrievePool = Outside.service(this,"gus.sys.script1.access.context.pool.latest");
		retrieveEvaluator = Outside.service(this,"gus.sys.script1.access.context.evaluator");
		retrieveOpMap = Outside.service(this,"gus.sys.script1.access.context.opmap");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=3) throw new Exception("Wrong data number: "+o.length);
		
		Map context = (Map) o[0];
		Object exp = o[1];
		Object rule = o[2];
		
		Map pool = (Map) retrievePool.t(context);
		T evaluator = (T) retrieveEvaluator.t(context);
		Map opMap = (Map) retrieveOpMap.t(context);
		
		return evaluator.t(new Object[]{pool,opMap,exp,rule});
	}
}
