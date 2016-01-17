package gus06.entity.gus.convert.ftor;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151124";}


	public Object t(Object obj) throws Exception
	{return new R1((F) obj);}
	
	
	
		
	
	private class R1 implements R
	{
		private F f;
		public R1(F f) {this.f = f;}
		
		public Object r(String key) throws Exception
		{return new Boolean(f.f(key));}
	}
}
