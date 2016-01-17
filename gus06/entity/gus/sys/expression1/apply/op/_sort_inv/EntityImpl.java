package gus06.entity.gus.sys.expression1.apply.op._sort_inv;

import gus06.framework.*;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151124";}
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return null;
		if(obj instanceof List) return sort((List) obj);
		if(obj instanceof Set) return sort(new ArrayList((Set) obj));
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	
	private List sort(List list)
	{
		Collections.sort(list,Collections.reverseOrder());
		return list;
	}
}
