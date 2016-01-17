package gus06.entity.gus.filter.string.build.unicode.startswith;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150526";}


	public Object t(Object obj) throws Exception
	{return new F_unicodeStartsWith((String)obj);}
	
	
	
	
	private class F_unicodeStartsWith implements F
	{
		private CharTools.CharType charType;
		
		public F_unicodeStartsWith(String value)
		{charType = CharTools.buildCharType(value);}
		
		public boolean f(Object obj) throws Exception
		{
			if(obj==null) return false;
			String str = obj.toString();
			if(str.equals("")) return false;
			
			char c = str.charAt(0);
			return charType.isTypeOf(c);
		}
	}
}
