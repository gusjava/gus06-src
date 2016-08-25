package gus06.entity.gus.feature.wrap.hhf.h;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160819";}

	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=3) throw new Exception("Wrong data number: "+o.length);
		
		H h1 = (H) o[0];
		H h2 = (H) o[1];
		F f = (F) o[2];
		
		return new Wrap(h1,h2,f);
	}
	
	
	
	
	
	private class Wrap implements H
	{
		private H h1;
		private H h2;
		private F f;
		
		public Wrap(H h1, H h2, F f)
		{
			this.h1 = h1;
			this.h2 = h2;
			this.f = f;
		}
		
		public double h(double value) throws Exception
		{
			return f.f(new Double(value)) ? h1.h(value) : h2.h(value);
		}
	}
}
