package gus06.entity.gus.feature.op.sum.p;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150707";}

	
	public Object t(Object obj) throws Exception
	{return new P1((P[]) obj);}
	
	
	private class P1 implements P
	{
		private P[] pp;
		public P1(P[] pp){this.pp = pp;}
		
		public void p(Object obj) throws Exception
		{for(P p:pp) p.p(obj);}
	}
}
