package gus06.entity.gus.filter.string.build.equals_i;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150526";}


	public Object t(Object obj) throws Exception
	{
		return new F_equals((String)obj);
	}
	
	
	private class F_equals implements F
	{
		private String value;
		public F_equals(String value)
		{this.value = value.toLowerCase();}
		
		public boolean f(Object obj) throws Exception
		{
			if(obj==null) return false;
			String str = (obj.toString()).toLowerCase();
			return str.equals(value);
		}
	}
}
