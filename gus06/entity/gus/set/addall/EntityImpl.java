package gus06.entity.gus.set.addall;

import gus06.framework.*;
import java.util.Set;
import java.util.Collection;
import java.util.HashSet;

public class EntityImpl implements Entity, P, T {

	public String creationDate() {return "20160128";}
	
	
	public void p(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		Set set = (Set) o[0];
		Collection data = (Collection) o[1];
		
		set.addAll(data);
	}
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		Set set = (Set) o[0];
		Collection data = (Collection) o[1];
		
		Set set1 = new HashSet(set);
		set1.addAll(data);
		
		return set1;
	}
}
