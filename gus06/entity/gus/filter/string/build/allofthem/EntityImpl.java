package gus06.entity.gus.filter.string.build.allofthem;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150526";}
	
	private Service splitMethod;
	
	
	public EntityImpl() throws Exception
	{
		splitMethod = Outside.service(this,"gus.string.split.method2");
	}
	
	public Object t(Object obj) throws Exception
	{
		String[] words = (String[]) splitMethod.t(obj);
		return new Filter(words);
	}
	
	
	private class Filter implements F
	{
		private String[] words;
		public Filter(String[] words)
		{this.words = words;}
		
		public boolean f(Object obj) throws Exception
		{
			if(obj==null) return false;
			String str = (String) obj;
			for(int i=0;i<words.length;i++)
				if(!str.contains(words[i])) return false;
			return true;
		}
	}
}
