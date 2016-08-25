package gus06.entity.gus.feature.wrap.ppf.p;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160414";}

	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=3) throw new Exception("Wrong data number: "+o.length);
		
		P p1 = (P) o[0];
		P p2 = (P) o[1];
		F f = (F) o[2];
		
		return new Wrap(p1,p2,f);
	}
	
	
	
	
	
	private class Wrap implements P
	{
		private P p1;
		private P p2;
		private F f;
		
		public Wrap(P p1, P p2, F f)
		{
			this.p1 = p1;
			this.p2 = p2;
			this.f = f;
		}
		
		public void p(Object obj) throws Exception
		{
			P p = f.f(obj) ? p1 : p2;
			p.p(obj);
		}
	}
}
