package gus06.entity.gus.set.add.ignore.d;

import gus06.framework.*;
import java.util.Set;
import java.util.HashSet;

public class EntityImpl implements Entity, P, T {

	public String creationDate() {return "20161218";}
	
	
	public void p(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		Set set = (Set) o[0];
		Object data = o[1];
		
		if(!set.contains(data))
		set.add(data);
		else System.out.println("data ignored: "+data);
	}
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		Set set = (Set) o[0];
		Object data = o[1];
		
		Set set1 = new HashSet(set);
		
		if(!set1.contains(data))
		set1.add(data);
		else System.out.println("data ignored: "+data);
		
		return set1;
	}
}
