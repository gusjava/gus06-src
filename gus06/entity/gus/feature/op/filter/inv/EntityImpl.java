package gus06.entity.gus.feature.op.filter.inv;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150707";}

	
	public Object t(Object obj) throws Exception
	{return new F1((F) obj);}
	
	
	private class F1 implements F
	{
		private F f;
		public F1(F f){this.f = f;}
		
		public boolean f(Object obj) throws Exception
		{return !f.f(obj);}
	}
}
