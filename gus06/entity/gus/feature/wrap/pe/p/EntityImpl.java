package gus06.entity.gus.feature.wrap.pe.p;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20161212";}

	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		P p = (P) o[0];
		E e = (E) o[1];
		
		return new Wrap(p,e);
	}
	
	
	
	
	
	private class Wrap implements P
	{
		private P p;
		private E e;
		
		public Wrap(P p, E e)
		{
			this.p = p;
			this.e = e;
		}
		
		public void p(Object obj) throws Exception
		{
			p.p(obj);
			e.e();
		}
	}
}
