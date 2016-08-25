package gus06.entity.gus.filter.string.build.containsnot_n;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160816";}
	
	
	private Service normalize;
	
	public EntityImpl() throws Exception
	{normalize = Outside.service(this,"gus.string.transform.normalize.diacritics.lower");}
	
	
	private String normalize(String s) throws Exception
	{return (String) normalize.t(s);}
	
	
	public Object t(Object obj) throws Exception
	{
		String s = normalize((String)obj);
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
			return !str.contains(value);
		}
	}
}
