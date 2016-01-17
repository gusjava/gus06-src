package gus06.entity.gus.filter.string.build.startswith_i;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150526";}

	
	public Object t(Object obj) throws Exception
	{
		String s = ((String)obj).toLowerCase();
		return new F_startsWith(s);
	}
	
	
	private class F_startsWith implements F
	{
		private String value;
		public F_startsWith(String value)
		{this.value = value;}
		
		public boolean f(Object obj) throws Exception
		{
			if(obj==null) return false;
			String str = (obj.toString()).toLowerCase();
			return str.startsWith(value);
		}
	}
}
