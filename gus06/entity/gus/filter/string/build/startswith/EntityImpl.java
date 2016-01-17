package gus06.entity.gus.filter.string.build.startswith;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20141112";}

	
	public Object t(Object obj) throws Exception
	{return new Filter((String) obj);}
	
	
	private class Filter implements F
	{
		private String s;
		public Filter(String s) {this.s = s;}
		
		public boolean f(Object obj) throws Exception
		{
			if(obj==null) return false;
			String str = obj.toString();
			return str.startsWith(s);
		}
	}
}