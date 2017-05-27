package gus06.entity.gus.set.mapvalue.at;

import gus06.framework.*;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20170425";}
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		Set input = (Set) o[0];
		Object value = o[1];
		
		Map output = new HashMap();
		
		Iterator it = input.iterator();
		while(it.hasNext())
		{
			Object key = it.next();
			output.put(key,value);
		}
		return output;
	}
}
