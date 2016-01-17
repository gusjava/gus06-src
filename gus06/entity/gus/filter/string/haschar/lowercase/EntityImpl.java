package gus06.entity.gus.filter.string.haschar.lowercase;

import gus06.framework.*;

public class EntityImpl implements Entity, F {

	public String creationDate() {return "20150526";}

	public boolean f(Object obj) throws Exception
	{
		if(obj==null) return false;

		String str = (String) obj;
		for(int i=0;i<str.length();i++)
			if(isLowerCase(str.charAt(i))) return true;
		return false;
	}

	private boolean isLowerCase(char c)
	{
		//return Character.isLowerCase(c);
		int code = (int) c;
		return code>96 && code<123;
	}
	//97-122 : a..z
}