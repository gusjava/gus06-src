package gus06.entity.gus.feature.op.sum.h;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150707";}

	
	public Object t(Object obj) throws Exception
	{return new H1((H[]) obj);}
	
	
	private class H1 implements H
	{
		private H[] hh;
		public H1(H[] hh){this.hh = hh;}
		
		public double h(double v) throws Exception
		{
			double r = 0;
			for(H h:hh) r += h.h(v);
			return r;
		}
	}
}
