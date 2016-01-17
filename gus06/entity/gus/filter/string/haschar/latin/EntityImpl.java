package gus06.entity.gus.filter.string.haschar.latin;

import gus06.framework.*;

public class EntityImpl implements Entity, F {

	public String creationDate() {return "20150526";}

	public static final String BLOCK = "BASIC_LATIN;LATIN_1_SUPPLEMENT";
	
	public boolean f(Object obj) throws Exception
	{
		if(obj==null) return false;
		
		String str = (String) obj;
		for(int i=0;i<str.length();i++)
		if(isValid(str.charAt(i))) return true;
		
		return false;
	}
		
	private boolean isValid(char c)
	{return BLOCK.contains(Character.UnicodeBlock.of(c).toString());}
}