package gus06.entity.gus.sys.parser3.resolver1.op.binary.equals;

import gus06.framework.*;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151029";}

	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		List[] cut = (List[]) o[0];
		T t = (T) o[1];
		
		if(cut.length!=2) throw new Exception("Invalid split for equals operation: "+cut.length);
		
		Object o1 = t.t(cut[0]);
		Object o2 = t.t(cut[1]);
		
		return new Boolean(equals(o1,o2));
	}
	
	
	private boolean equals(Object o1, Object o2)
	{
		if(o1==null && o2==null) return true;
		if(o1==null || o2==null) return false;
		
		if(o1 instanceof Number && o2 instanceof Number)
		{
			double d1 = ((Number) o1).doubleValue();
			double d2 = ((Number) o2).doubleValue();
			return d1==d2;
		}
		return o1.equals(o2);
	}
}
