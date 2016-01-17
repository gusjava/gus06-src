package gus06.entity.gus.sys.expression1.apply.op._reverse;

import gus06.framework.*;
import java.util.List;
import java.util.Collections;
import java.util.ArrayList;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151109";}
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return null;
		if(obj instanceof String) return reverse((String) obj);
		if(obj instanceof List) return reverse((List) obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	
	private String reverse(String s)
	{
		StringBuffer b = new StringBuffer(s);
		return b.reverse().toString();
	}
	
	
	private List reverse(List list)
	{
		List list1 = new ArrayList(list);
		Collections.reverse(list1);
		return list1;
	}
}
