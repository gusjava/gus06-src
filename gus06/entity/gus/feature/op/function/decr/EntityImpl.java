package gus06.entity.gus.feature.op.function.decr;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160816";}

	
	public Object t(Object obj) throws Exception
	{return new H1((H) obj);}
	
	
	private class H1 implements H
	{
		private H h;
		public H1(H h){this.h = h;}
		
		public double h(double v) throws Exception
		{return h.h(v)-1;}
	}
}
