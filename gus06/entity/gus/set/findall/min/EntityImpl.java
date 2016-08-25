package gus06.entity.gus.set.findall.min;

import gus06.framework.*;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160820";}
	
	
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		Set input = (Set) o[0];
		T t = (T) o[1];
		
		Set output = new HashSet();
		if(input.isEmpty()) return output;
		
		Iterator it = input.iterator();
		Object element0 = it.next();
		output.add(element0);
		Comparable minValue = (Comparable) t.t(element0);
		
		while(it.hasNext())
		{
			Object element = it.next();
			Comparable value = (Comparable) t.t(element);
			int r = value.compareTo(minValue);
			
			if(r<0)
			{
				minValue = value;
				output.clear();
				output.add(element);
			}
			else if(r==0)
			{
				output.add(element);
			}
		}
		return output;
	}
}
