package gus06.entity.gus.filter.string.build.endswith_i;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150526";}


	public Object t(Object obj) throws Exception
	{
		String s = ((String)obj).toLowerCase();
		return new F_endsWith(s);
	}
	
	
	private class F_endsWith implements F
	{
		private String value;
		public F_endsWith(String value)
		{this.value = value;}
		
		public boolean f(Object obj) throws Exception
		{
			if(obj==null) return false;
			String str = (obj.toString()).toLowerCase();
			return str.endsWith(value);
		}
	}
}