package gus06.entity.gus.sys.parser3.resolver1.op.binary.hasnot;

import gus06.framework.*;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Set;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151030";}

	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		List[] cut = (List[]) o[0];
		T t = (T) o[1];
		
		if(cut.length!=2) throw new Exception("Invalid split for equals operation: "+cut.length);
		
		Object o1 = t.t(cut[0]);
		Object o2 = t.t(cut[1]);
		
		if(o1 instanceof List)
		{
			List list = (List) o1;
			return new Boolean(!list.contains(o2));
		}
		
		if(o1 instanceof Set)
		{
			Set set = (Set) o1;
			return new Boolean(!set.contains(o2));
		}
		
		if(o1 instanceof Map)
		{
			Map map = (Map) o1;
			return new Boolean(!map.containsKey(o2));
		}
		
		throw new Exception("Invalid has operation");
	}
}
