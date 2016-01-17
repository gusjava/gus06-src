package gus06.entity.gus.sys.expression1.evaluate;

import gus06.framework.*;
import java.util.List;
import java.util.Map;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150905";}


	private Service evaluate;
	private Service buildExternal;
	

	public EntityImpl() throws Exception
	{
		evaluate = Outside.service(this,"gus.sys.parser3.evaluate");
		buildExternal = Outside.service(this,"gus.sys.expression1.external");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		
		if(o.length==3)
		{
			List pools = (List) o[0];
			Map opMap = (Map) o[1];
			String exp = (String) o[2];
			
			T external = buildExternal(pools,opMap);
		
			evaluate.v("rule",null);
			evaluate.v("external",external);
			
			return evaluate.t(exp.trim());
		}
		
		if(o.length==4)
		{
			List pools = (List) o[0];
			Map opMap = (Map) o[1];
			String exp = (String) o[2];
			String rule = (String) o[3];
			
			T external = buildExternal(pools,opMap);
		
			evaluate.v("rule",rule);
			evaluate.v("external",external);
			
			return evaluate.t(exp.trim());
		}
		
		throw new Exception("Wrong data number: "+o.length);
	}
	
	
	private T buildExternal(List pools, Map opMap) throws Exception
	{return (T) buildExternal.t(new Object[]{pools,opMap});}
}
