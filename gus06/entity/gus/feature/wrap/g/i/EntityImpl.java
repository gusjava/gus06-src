package gus06.entity.gus.feature.wrap.g.i;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20161211";}

	
	
	public Object t(Object obj) throws Exception
	{
		G g = (G) obj;
		return new Wrap(g);
	}
	
	
	
	
	
	private class Wrap implements I
	{
		private G g;
		
		public Wrap(G g)
		{
			this.g = g;
		}
		
		public Object i() throws Exception
		{
			return g.g();
		}
	}
}
