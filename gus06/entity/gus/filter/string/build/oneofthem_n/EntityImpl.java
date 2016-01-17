package gus06.entity.gus.filter.string.build.oneofthem_n;


import gus06.framework.*;



public class EntityImpl implements Entity, T {



	public String creationDate() {return "20150529";}


	private Service charNormalize;
	private Service cuttingMethod;
	
	public EntityImpl() throws Exception
	{
		charNormalize = Outside.service(this,"gus.string.transform.normalize.diacritics.lower");
		cuttingMethod = Outside.service(this,"gus.string.split.method1");
	}


	private String normalize(String s) throws Exception
	{return (String) charNormalize.t(s);}

	
	public Object t(Object obj) throws Exception
	{
		String s = normalize((String)obj);
		String[] words = (String[]) cuttingMethod.t(s);
		return new F_oneOfThem(words);
	}
	
	
	
	private class F_oneOfThem implements F
	{
		private String[] words;
		public F_oneOfThem(String[] words)
		{this.words = words;}
		
		public boolean f(Object obj) throws Exception
		{
			if(obj==null) return false;
			String str = normalize(obj.toString());
			for(int i=0;i<words.length;i++)
				if(str.contains(words[i])) return true;
			return false;
		}
	}
}
