package gus06.entity.gus.filter.string.build.endswith_n;

import gus06.framework.*;

public class EntityImpl implements Entity, T {


	public String creationDate() {return "20150526";}


	private Service charNormalize;
	
	public EntityImpl() throws Exception
	{charNormalize = Outside.service(this,"gus.string.transform.normalize.diacritics.lower");}


	private String normalize(String s) throws Exception
	{return (String) charNormalize.t(s);}

	
	public Object t(Object obj) throws Exception
	{
		String s = normalize((String)obj);
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
			String str = normalize(obj.toString());
			return str.endsWith(value);
		}
	}
}
