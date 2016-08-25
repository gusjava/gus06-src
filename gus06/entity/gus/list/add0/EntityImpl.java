package gus06.entity.gus.list.add0;

import gus06.framework.*;
import java.util.List;
import java.util.ArrayList;

public class EntityImpl implements Entity, P, T {

	public String creationDate() {return "20160130";}
	
	
	public void p(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		List list = (List) o[0];
		Object data = o[1];
		
		list.add(0,data);
	}
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		List list = (List) o[0];
		Object data = o[1];
		
		List list1 = new ArrayList();
		
		list1.add(data);
		list1.addAll(list);
		
		return list1;
	}
}
