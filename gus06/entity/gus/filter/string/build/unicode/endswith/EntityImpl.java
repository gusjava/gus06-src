package gus06.entity.gus.filter.string.build.unicode.endswith;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150526";}


	public Object t(Object obj) throws Exception
	{return new Filter((String) obj);}
	
	
	
	private class Filter implements F
	{
		private CharTools.CharType charType;
		
		public Filter(String value)
		{charType = CharTools.buildCharType(value);}
		
		public boolean f(Object obj) throws Exception
		{
			if(obj==null) return false;
			String str = (String) obj;
			if(str.equals("")) return false;
			
			char c = str.charAt(str.length()-1);
			return charType.isTypeOf(c);
		}
	}
}
