package gus06.entity.gus.filter.string.build.containsnot;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160816";}
	
	
	public Object t(Object obj) throws Exception
	{
		String s = (String)obj;
		return new Filter(s);
	}
	
	
	private class Filter implements F
	{
		private String value;
		public Filter(String value)
		{this.value = value;}
		
		public boolean f(Object obj) throws Exception
		{
			if(obj==null) return false;
			String str = (String) obj;
			return !str.contains(value);
		}
	}
}
