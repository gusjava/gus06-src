package gus06.entity.gus.convert.ftot;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151118";}


	public Object t(Object obj) throws Exception
	{return new T1((F) obj);}
	
	
	
		
	
	private class T1 implements T
	{
		private F f;
		public T1(F f) {this.f = f;}
		
		public Object t(Object obj) throws Exception
		{return new Boolean(f.f(obj));}
	}
}
