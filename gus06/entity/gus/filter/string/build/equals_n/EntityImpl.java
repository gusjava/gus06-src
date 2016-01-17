package gus06.entity.gus.filter.string.build.equals_n;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150526";}

	private Service charNormalize;
	
	public EntityImpl() throws Exception
	{
		charNormalize = Outside.service(this,"gus.string.transform.normalize.diacritics.lower");
	}


	private String normalize(String s) throws Exception
	{return (String) charNormalize.t(s);}

	
	public Object t(Object obj) throws Exception
	{
		String s = normalize((String)obj);
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
			String str = normalize(obj.toString());
			return str.equals(value);
		}
	}
}
