package gus06.entity.gus.filter.string.simple1;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20140819";}

	
	
	public Object t(Object obj) throws Exception
	{return new Filter((String) obj);}
	
	
	private class Filter implements F
	{
		private String[] n;
		public Filter(String s)
		{
			if(s==null || s.equals("")) return;
			n = s.toLowerCase().split(" ");
		}
		
		public boolean f(Object obj) throws Exception
		{
			if(n==null) return true;
			
			String s = ((String) obj).toLowerCase();
			for(int i=0;i<n.length;i++)
				if(s.contains(n[i])) return true;
			return false;
		}
	}
}
