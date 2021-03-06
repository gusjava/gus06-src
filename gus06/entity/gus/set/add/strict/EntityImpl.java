package gus06.entity.gus.set.add.strict;

import gus06.framework.*;
import java.util.Set;
import java.util.HashSet;

public class EntityImpl implements Entity, P, T {

	public String creationDate() {return "20160712";}
	
	
	public void p(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		Set set = (Set) o[0];
		Object data = o[1];
		
		if(set.contains(data))
			throw new Exception("Element already used inside set: "+data);
		
		set.add(data);
	}
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		Set set = (Set) o[0];
		Object data = o[1];
		
		if(set.contains(data))
			throw new Exception("Element already used inside set: "+data);
		
		Set set1 = new HashSet(set);
		set1.add(data);
		
		return set1;
	}
}
