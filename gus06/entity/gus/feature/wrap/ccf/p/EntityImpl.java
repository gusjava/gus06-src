package gus06.entity.gus.feature.wrap.ccf.p;

import gus06.framework.*;
import java.util.Collection;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160414";}

	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=3) throw new Exception("Wrong data number: "+o.length);
		
		Collection c1 = (Collection) o[0];
		Collection c2 = (Collection) o[1];
		F f = (F) o[2];
		
		return new Wrap(c1,c2,f);
	}
	
	
	
	private class Wrap implements P
	{
		private Collection c1;
		private Collection c2;
		private F f;
		
		public Wrap(Collection c1, Collection c2, F f)
		{
			this.c1 = c1;
			this.c2 = c2;
			this.f = f;
		}
		
		public void p(Object obj) throws Exception
		{
			Collection c = f.f(obj) ? c1 : c2;
			c.add(obj);
		}
	}
	
}
