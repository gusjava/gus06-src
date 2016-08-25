package gus06.entity.gus.feature.wrap.hf.h;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160819";}

	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		H h = (H) o[0];
		F f = (F) o[1];
		
		return new Wrap(h,f);
	}
	
	
	
	
	
	private class Wrap implements H
	{
		private H h;
		private F f;
		
		public Wrap(H h, F f)
		{
			this.h = h;
			this.f = f;
		}
		
		public double h(double value) throws Exception
		{
			return f.f(new Double(value)) ? h.h(value) : value;
		}
	}
}
