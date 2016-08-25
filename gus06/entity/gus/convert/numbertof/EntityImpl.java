package gus06.entity.gus.convert.numbertof;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160808";}


	public Object t(Object obj) throws Exception
	{return new F1((Number) obj);}
	
	
	
	private class F1 implements F
	{
		private double v;
		
		public F1(Number n)
		{v = n.doubleValue();}
		
		public boolean f(Object obj) throws Exception
		{
			if(!(obj instanceof Number)) return false;
			return ((Number) obj).doubleValue()==v;
		}
	}
}
