package gus06.entity.gus.collection.containsall.coltof;

import gus06.framework.*;
import java.util.Collection;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160201";}
	
	
	public Object t(Object obj) throws Exception
	{return new F1((Collection) obj);}
	
	
	private class F1 implements F
	{
		private Collection c;
		public F1(Collection c){this.c = c;}
		
		public boolean f(Object obj) throws Exception
		{
			Collection c0 = (Collection) obj;
			return c.containsAll(c0);
		}
	}
}
