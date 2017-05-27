package gus06.entity.gus.list.mapkey.strict;

import gus06.framework.*;
import java.util.Map;
import java.util.HashMap;
import java.util.List;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20170327";}
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		List input = (List) o[0];
		T t = (T) o[1];
		
		Map output = new HashMap();
		int nb = input.size();
		
		for(int i=0;i<nb;i++)
		{
			Object element = input.get(i);
			
			Object key = t.t(element);
			Object value = element;
			
			if(output.containsKey(key))
				throw new Exception("Duplicated key found: "+key);
			output.put(key,value);
		}
		return output;
	}
}
