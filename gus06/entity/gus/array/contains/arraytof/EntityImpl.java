package gus06.entity.gus.array.contains.arraytof;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160120";}
	
	
	public Object t(Object obj) throws Exception
	{return new F1((Object[]) obj);}
	
	
	private class F1 implements F
	{
		private Object[] aa;
		public F1(Object[] aa){this.aa = aa;}
		
		public boolean f(Object obj) throws Exception
		{return contains(aa,obj);}
	}
	
	private boolean contains(Object[] aa, Object obj)
	{
		for(Object a:aa) if(obj.equals(a)) return true;
		return false;
	}
}
