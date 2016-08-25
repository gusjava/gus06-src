package gus06.entity.gus.convert.booleantof;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160816";}


	public Object t(Object obj) throws Exception
	{return new F1((Boolean) obj);}
	
	
	
	private class F1 implements F
	{
		private boolean v;
		
		public F1(Boolean b)
		{v = b.booleanValue();}
		
		public boolean f(Object obj) throws Exception
		{return v;}
	}
}
