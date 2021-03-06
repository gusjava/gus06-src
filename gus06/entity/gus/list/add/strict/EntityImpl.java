package gus06.entity.gus.list.add.strict;

import gus06.framework.*;
import java.util.List;
import java.util.ArrayList;

public class EntityImpl implements Entity, P, T {

	public String creationDate() {return "20161207";}
	
	
	public void p(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		List list = (List) o[0];
		Object data = o[1];
		
		if(list.contains(data))
			throw new Exception("Element already used inside list: "+data);
		
		list.add(data);
	}
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		List list = (List) o[0];
		Object data = o[1];
		
		if(list.contains(data))
			throw new Exception("Element already used inside list: "+data);
			
		List list1 = new ArrayList(list);
		list1.add(data);
		
		return list1;
	}
}
