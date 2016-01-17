package gus06.entity.gus.filter.string.build.oneofthem_i;


import gus06.framework.*;



public class EntityImpl implements Entity, T {



	public String creationDate() {return "20150529";}


	private Service cuttingMethod;
	
	public EntityImpl() throws Exception
	{
		cuttingMethod = Outside.service(this,"gus.string.split.method1");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		String s = ((String)obj).toLowerCase();
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
			String str = (obj.toString()).toLowerCase();
			for(int i=0;i<words.length;i++)
				if(str.contains(words[i])) return true;
			return false;
		}
	}
}
