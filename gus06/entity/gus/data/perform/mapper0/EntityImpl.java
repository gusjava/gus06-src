package gus06.entity.gus.data.perform.mapper0;

import gus06.framework.*;
import java.util.Collection;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151119";}
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		Collection c = (Collection) o[0];
		T trans = (T) o[1];
		
		Map output = new HashMap();
		
		Iterator it = c.iterator();
		while(it.hasNext())
		{
			Object key = it.next();
			Object value = trans.t(key);
			
			output.put(key,value);
		}
		return output;
	}
}
