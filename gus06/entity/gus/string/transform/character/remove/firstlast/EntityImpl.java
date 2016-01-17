package gus06.entity.gus.string.transform.character.remove.firstlast;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150927";}
	
	
	public Object t(Object obj) throws Exception
	{
		String s = (String) obj;
		int l = s.length();
		if(l==0) return "";
		return s.substring(1,l-1);
	}
}
