package gus06.entity.gus.filter.string.build.near_i;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150529";}


	private Service comparator;
	
	public EntityImpl() throws Exception
	{
		comparator = Outside.service(this,"gus.data.compare.string.comparator1");
	}


	
	public Object t(Object obj) throws Exception
	{
		String s = ((String) obj).toLowerCase();
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
			String str = ((String) obj).toLowerCase();
			return comparator.f(new String[]{str,value});
		}
	}
}
