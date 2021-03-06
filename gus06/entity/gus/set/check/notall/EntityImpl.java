package gus06.entity.gus.set.check.notall;

import gus06.framework.*;
import java.util.Set;
import java.util.Iterator;

public class EntityImpl implements Entity, F {

	public String creationDate() {return "20160805";}
	
	
	public boolean f(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		Set input = (Set) o[0];
		F filter = (F) o[1];
		
		Iterator it = input.iterator();
		while(it.hasNext())
		{
			Object element = it.next();
			if(!filter.f(element)) return true;
		}
		return false;
	}
}
