package gus06.entity.gus.array.objectarray.findall3.buildmap;

import gus06.framework.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20170326";}
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		Object[] input = (Object[]) o[0];
		Integer index = (Integer) o[1];
		
		int i = index.intValue();
		int nb = input.length;
		Object element = input[i];
		
		Map m = new HashMap();
		
		put(m,"list",input);
		put(m,"index",new Integer(i));
		put(m,"size",new Integer(nb));
		put(m,"first",new Boolean(i==0));
		put(m,"last",new Boolean(i==nb-1));
		put(m,"current",element);
		put(m,"others",others(input,i));
		
		put(m,"next",get(input,i+1));
		put(m,"next2",get(input,i+2));
		put(m,"next3",get(input,i+3));
		put(m,"previous",get(input,i-1));
		put(m,"previous2",get(input,i-2));
		put(m,"previous3",get(input,i-3));
			
		return m;
	}
	
	
	private void put(Map map, String key, Object value)
	{
		if(value!=null) map.put(key,value);
	}
	
	private Object get(Object[] array, int index)
	{
		if(index<0 || index>=array.length) return null;
		return array[index];
	}
	
	private List others(Object[] array, int index)
	{
		List list1 = new ArrayList(Arrays.asList(array));
		list1.remove(index);
		return list1;
	}
}
