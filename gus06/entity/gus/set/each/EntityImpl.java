package gus06.entity.gus.set.each;

import gus06.framework.*;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20151125";}
	
	
	public void p(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		Set input = (Set) o[0];
		T t = (T) o[1];
		
		Set output = new HashSet();
		Iterator it = input.iterator();
		while(it.hasNext())
		{
			Object element = it.next();
			output.add(t.t(element));
		}
		input.clear();
		input.addAll(output);
	}
}