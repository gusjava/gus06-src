package gus06.entity.gus.feature.wrap.pf.p;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160414";}

	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		P p = (P) o[0];
		F f = (F) o[1];
		
		return new Wrap(p,f);
	}
	
	
	
	
	
	private class Wrap implements P
	{
		private P p;
		private F f;
		
		public Wrap(P p, F f)
		{
			this.p = p;
			this.f = f;
		}
		
		public void p(Object obj) throws Exception
		{
			if(f.f(obj)) p.p(obj);
		}
	}
}
