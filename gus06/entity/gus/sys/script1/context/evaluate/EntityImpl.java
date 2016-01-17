package gus06.entity.gus.sys.script1.context.evaluate;

import gus06.framework.*;
import java.util.Map;
import java.util.List;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151031";}


	private Service retrievePools;
	private Service retrieveEvaluator;
	private Service retrieveOpMap;
	
	public EntityImpl() throws Exception
	{
		retrievePools = Outside.service(this,"gus.sys.script1.access.context.pool1.all");
		retrieveEvaluator = Outside.service(this,"gus.sys.script1.access.context.evaluator");
		retrieveOpMap = Outside.service(this,"gus.sys.script1.access.context.opmap");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		Map context = (Map) o[0];
		String exp = (String) o[1];
		
		List pools = (List) retrievePools.t(context);
		T evaluator = (T) retrieveEvaluator.t(context);
		Map opMap = (Map) retrieveOpMap.t(context);
		
		return evaluator.t(new Object[]{pools,opMap,exp});
	}
}
