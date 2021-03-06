package gus06.entity.gus.set.remove;

import gus06.framework.*;
import java.util.Set;
import java.util.HashSet;

public class EntityImpl implements Entity, P, T {

	public String creationDate() {return "20161215";}
	
	
	public void p(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		Set set = (Set) o[0];
		Object element = o[1];
		
		set.remove(element);
	}
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		Set set = (Set) o[0];
		Object element = o[1];
		
		Set set1 = new HashSet(set);
		set1.remove(element);
		return set1;
	}
}
