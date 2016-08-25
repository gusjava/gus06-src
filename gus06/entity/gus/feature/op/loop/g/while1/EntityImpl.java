package gus06.entity.gus.feature.op.loop.g.while1;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160312";}

	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		G g = (G) o[0];
		F f = (F) o[1];
		
		return new G1(g,f);
	}
	
	private class G1 implements G
	{
		private G g;
		private F f;
		
		public G1(G g, F f)
		{
			this.g = g;
			this.f = f;
		}
		
		public Object g() throws Exception
		{
			Object r = g.g();
			while(f.f(r)) r = g.g();
			return r;
		}
	}
}
