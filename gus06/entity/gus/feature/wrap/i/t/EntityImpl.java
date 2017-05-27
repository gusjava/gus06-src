package gus06.entity.gus.feature.wrap.i.t;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20161210";}

	
	
	public Object t(Object obj) throws Exception
	{
		I i = (I) obj;
		return new Wrap(i);
	}
	
	
	
	
	
	private class Wrap implements T
	{
		private I i;
		
		public Wrap(I i)
		{
			this.i = i;
		}
		
		public Object t(Object obj) throws Exception
		{
			return i.i();
		}
	}
}
