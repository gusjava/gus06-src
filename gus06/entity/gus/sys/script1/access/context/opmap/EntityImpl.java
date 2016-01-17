package gus06.entity.gus.sys.script1.access.context.opmap;

import gus06.framework.*;
import java.util.Map;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151123";}
	
	public static final String C_EXP_OPERATORS = "exp_operators";


	
	public Object t(Object obj) throws Exception
	{
		Map context = (Map) obj;
		
		Map opMap = (Map) get(context,C_EXP_OPERATORS);
		return opMap;
	}
	
	
	private Object get(Map map, String key)
	{return map.containsKey(key)?map.get(key):null;}
}
