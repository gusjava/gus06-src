package gus06.entity.gus.list.insertall;

import gus06.framework.*;
import java.util.List;
import java.util.Collection;

public class EntityImpl implements Entity, P, T {

	public String creationDate() {return "20160131";}
	
	
	public void p(Object obj) throws Exception
	{t(obj);}
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=3) throw new Exception("Wrong data number: "+o.length);
		
		List list = (List) o[0];
		Integer index = (Integer) o[1];
		Collection data = (Collection) o[2];
		
		list.addAll(index.intValue(),data);
		return data;
	}
}
