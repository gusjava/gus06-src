package gus06.entity.gus.filter.string.build.near_n;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150529";}


	private Service normalize;
	private Service comparator;
	
	public EntityImpl() throws Exception
	{
		normalize = Outside.service(this,"gus.string.transform.normalize.diacritics.lower");
		comparator = Outside.service(this,"gus.data.compare.string.comparator1");
	}


	private String normalize(String s) throws Exception
	{return (String) normalize.t(s);}

	
	public Object t(Object obj) throws Exception
	{
		String s = normalize((String) obj);
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
			String str = normalize((String) obj);
			return comparator.f(new String[]{str,value});
		}
	}
}
