package gus06.entity.gus.feature.wrap.ptg.e;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150707";}

	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=3) throw new Exception("Wrong data number: "+o.length);
		
		P p = (P) o[0];
		T t = (T) o[1];
		G g = (G) o[2];
		
		return new Wrap(p,t,g);
	}
	
	
	
		
	
	private class Wrap implements E
	{
		private P p;
		private T t;
		private G g;
		
		public Wrap(P p, T t, G g)
		{
			this.p = p;
			this.t = t;
			this.g = g;
		}
		
		public void e() throws Exception
		{
			p.p(t.t(g.g()));
		}
	}
}
