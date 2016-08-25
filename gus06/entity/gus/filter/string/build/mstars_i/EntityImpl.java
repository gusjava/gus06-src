package gus06.entity.gus.filter.string.build.mstars_i;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160404";}


	
	
	public Object t(Object obj) throws Exception
	{
		String s = ((String) obj).toLowerCase();
		return new Filter(s);
	}
	
	
	private class Filter implements F
	{
		private String s;
		private boolean start;
		private boolean end;
		
		public Filter(String s)
		{
			start = s.startsWith("*");
			end = s.endsWith("*");
			
			if(start && end) this.s = s.substring(1,s.length()-1);
			else if(start) this.s = s.substring(1);
			else if(end) this.s = s.substring(0,s.length()-1);
			else this.s = s;
		}
		
		public boolean f(Object obj) throws Exception
		{
			if(obj==null) return false;
			String s0 = ((String) obj).toLowerCase();
			
			if(start && end) return s0.contains(s);
			if(start) return s0.endsWith(s);
			if(end) return s0.startsWith(s);
			return s0.equals(s);
		}
	}
}
