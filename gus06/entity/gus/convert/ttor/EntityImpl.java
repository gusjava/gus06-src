package gus06.entity.gus.convert.ttor;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151124";}


	public Object t(Object obj) throws Exception
	{return new R1((T) obj);}
	
		
	
	private class R1 implements R
	{
		private T t;
		public R1(T t) {this.t = t;}
		
		public Object r(String key) throws Exception
		{return t.t(key);}
	}
}
