package gus06.entity.gus.set.removeat;

import gus06.framework.*;
import java.util.Set;

public class EntityImpl implements Entity, P, T {

	public String creationDate() {return "20151205";}
	
	
	public void p(Object obj) throws Exception
	{t(obj);}
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		Set set = (Set) o[0];
		Object element = o[1];
		
		if(set.remove(element)) return element;
		return null;
	}
}
