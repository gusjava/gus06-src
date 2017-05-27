package gus06.entity.gus.array.objectarray.mapvalue2;

import gus06.framework.*;
import java.util.Map;
import java.util.HashMap;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20170327";}
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		Object[] input = (Object[]) o[0];
		T t = (T) o[1];
		
		Map output = new HashMap();
		int nb = input.length;
		
		for(int i=0;i<nb;i++)
		{
			Object element = input[i];
			
			Object key = element;
			Object value = t.t(new Object[]{element,input});
			
			output.put(key,value);
		}
		return output;
	}
}
