package gus06.entity.gus.feature.wrap.pfg.e;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160414";}

	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=3) throw new Exception("Wrong data number: "+o.length);
		
		P p = (P) o[0];
		F f = (F) o[1];
		G g = (G) o[2];
		
		return new Wrap(p,f,g);
	}
	
	
	
		
	
	private class Wrap implements E
	{
		private P p;
		private F f;
		private G g;
		
		public Wrap(P p, F f, G g)
		{
			this.p = p;
			this.f = f;
			this.g = g;
		}
		
		public void e() throws Exception
		{
			Object data = g.g();
			if(f.f(data)) p.p(data);
		}
	}
}
