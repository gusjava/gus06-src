package gus06.entity.gus.filter.string.build.near;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150529";}


	private Service comparator;
	
	public EntityImpl() throws Exception
	{
		comparator = Outside.service(this,"gus.data.compare.string.comparator2");
	}


	
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
			return comparator.f(new String[]{str,value});
		}
	}
}
