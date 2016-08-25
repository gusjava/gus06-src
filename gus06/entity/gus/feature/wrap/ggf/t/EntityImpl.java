package gus06.entity.gus.feature.wrap.ggf.t;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160414";}

	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=3) throw new Exception("Wrong data number: "+o.length);
		
		G g1 = (G) o[0];
		G g2 = (G) o[1];
		F f = (F) o[2];
		
		return new Wrap(g1,g2,f);
	}
	
	
	
	
	
	private class Wrap implements T
	{
		private G g1;
		private G g2;
		private F f;
		
		public Wrap(G g1, G g2, F f)
		{
			this.g1 = g1;
			this.g2 = g2;
			this.f = f;
		}
		
		public Object t(Object obj) throws Exception
		{
			return f.f(obj) ? g1.g() : g2.g();
		}
	}
}
