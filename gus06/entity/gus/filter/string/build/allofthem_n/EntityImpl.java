package gus06.entity.gus.filter.string.build.allofthem_n;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150526";}
	
	
	private Service charNormalize;
	private Service splitMethod;
	
	
	public EntityImpl() throws Exception
	{
		charNormalize = Outside.service(this,"gus.string.transform.normalize.diacritics.lower");
		splitMethod = Outside.service(this,"gus.string.split.method2");
	}
	
	
	private String normalize(String s) throws Exception
	{return (String) charNormalize.t(s);}
	
	
	
	public Object t(Object obj) throws Exception
	{
		String s = normalize((String)obj);
		String[] words = (String[]) splitMethod.t(s);
		return new F_allOfThem(words);
	}
	
	
	private class F_allOfThem implements F
	{
		private String[] words;
		public F_allOfThem(String[] words)
		{this.words = words;}
		
		public boolean f(Object obj) throws Exception
		{
			if(obj==null) return false;
			String str = normalize(obj.toString());
			for(int i=0;i<words.length;i++)
				if(!str.contains(words[i])) return false;
			return true;
		}
	}
}
