package gus06.entity.gus.feature.wrap.g2h.h;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160805";}

	
	
	public Object t(Object obj) throws Exception
	{
		G g = (G) obj;
		return new Wrap(g);
	}
	
	
	
	
	
	private class Wrap implements H
	{
		private G g;
		public Wrap(G g) {this.g = g;}
		
		public double h(double value) throws Exception
		{
			H h = (H) g.g();
			return h.h(value);
		}
	}
}
