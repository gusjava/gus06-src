package gus06.entity.gus.filter.string.build.unicode.contains;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150526";}


	public Object t(Object obj) throws Exception
	{return new F_unicodeContains((String)obj);}
	
	
	
	private class F_unicodeContains implements F
	{
		private CharTools.CharType charType;
		
		public F_unicodeContains(String value)
		{charType = CharTools.buildCharType(value);}
		
		public boolean f(Object obj) throws Exception
		{
			if(obj==null) return false;
			String str = obj.toString();
			
			for(int i=0;i<str.length();i++)
			{
				char c = str.charAt(i);
				if(charType.isTypeOf(c)) return true;
			}
			return false;
		}
	}
}
