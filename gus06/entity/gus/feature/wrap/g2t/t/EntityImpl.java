package gus06.entity.gus.feature.wrap.g2t.t;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160805";}

	
	
	public Object t(Object obj) throws Exception
	{
		G g = (G) obj;
		return new Wrap(g);
	}
	
	
	
	
	
	private class Wrap implements T
	{
		private G g;
		public Wrap(G g) {this.g = g;}
		
		public Object t(Object obj) throws Exception
		{
			T t = (T) g.g();
			return t.t(obj);
		}
	}
}
