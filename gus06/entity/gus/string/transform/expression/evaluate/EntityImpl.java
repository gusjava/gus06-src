package gus06.entity.gus.string.transform.expression.evaluate;

import gus06.framework.*;
import java.util.Map;
import java.util.HashMap;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160828";}


	private Service evaluate;
	private Service getOpMap;


	public EntityImpl() throws Exception
	{
		evaluate = Outside.service(this,"gus.sys.expression1.evaluate");
		getOpMap = Outside.service(this,"gus.sys.expression1.apply.opmap");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		String exp = (String) obj;
		Map opMap = (Map) getOpMap.g();
		Map pool = new HashMap();
		
		Object r = evaluate.t(new Object[]{pool,opMap,exp});
		return ""+r;
	}
}
