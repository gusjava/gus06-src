package gus06.entity.gus.string.transform.character.keep.last;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150926";}
	
	
	public Object t(Object obj) throws Exception
	{
		String s = (String) obj;
		int l = s.length();
		if(l==0) return "";
		return s.substring(l-1,l);
	}
}
