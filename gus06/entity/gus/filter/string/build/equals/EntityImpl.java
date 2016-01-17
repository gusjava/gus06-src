package gus06.entity.gus.filter.string.build.equals;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150526";}

	
	public Object t(Object obj) throws Exception
	{
		String s = (String)obj;
		return new F_equals(s);
	}
	
	
	private class F_equals implements F
	{
		private String value;
		public F_equals(String value)
		{this.value = value;}
		
		public boolean f(Object obj) throws Exception
		{
			if(obj==null) return false;
			String str = obj.toString();
			return str.equals(value);
		}
	}
}
