package gus06.entity.gus.filter.string.build.unicode.equals;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150526";}


	public Object t(Object obj) throws Exception
	{return new F_unicodeEquals((String)obj);}
	
	
	
	private class F_unicodeEquals implements F
	{
		private CharTools.CharType charType;
		
		public F_unicodeEquals(String value)
		{charType = CharTools.buildCharType(value);}
		
		public boolean f(Object obj) throws Exception
		{
			if(obj==null) return false;
			String str = (String)obj;
			if(str.equals("")) return false;
			
			for(int i=0;i<str.length();i++)
			{
				char c = str.charAt(i);
				if(!charType.isTypeOf(c)) return false;
			}
			return true;
		}
	}
}
