package gus06.entity.gus.filter.array.build.any;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160804";}

	
	public Object t(Object obj) throws Exception
	{return new F1((F[]) obj);}
	
	
	private class F1 implements F
	{
		private F[] ff;
		public F1(F[] ff){this.ff = ff;}
		
		public boolean f(Object obj) throws Exception
		{
			for(F f:ff) if(f.f(obj)) return true;
			return false;
		}
	}
}
