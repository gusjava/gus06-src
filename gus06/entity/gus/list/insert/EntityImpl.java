package gus06.entity.gus.list.insert;

import gus06.framework.*;
import java.util.List;

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
		Object data = o[2];
		
		list.add(index.intValue(),data);
		return data;
	}
}
