package gus06.entity.gus.array.containsall.arraytof;

import gus06.framework.*;
import java.util.Collection;
import java.util.Iterator;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160201";}
	
	
	public Object t(Object obj) throws Exception
	{return new F1((Object[]) obj);}
	
	
	private class F1 implements F
	{
		private Object[] aa;
		public F1(Object[] aa){this.aa = aa;}
		
		public boolean f(Object obj) throws Exception
		{return containsCol(aa,(Collection) obj);}
	}
	
	
	private boolean containsCol(Object[] aa, Collection c)
	{
		Iterator it = c.iterator();
		while(it.hasNext())
		{
			Object element = it.next();
			if(!contains(aa,element)) return false;
		}
		return true;
	}
	
	
	private boolean contains(Object[] aa, Object obj)
	{
		for(Object a:aa) if(obj.equals(a)) return true;
		return false;
	}
}
