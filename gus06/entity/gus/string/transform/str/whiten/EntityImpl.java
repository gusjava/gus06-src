package gus06.entity.gus.string.transform.str.whiten;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160517";}

	
	
	public Object t(Object obj) throws Exception
	{
		String s = (String) obj;
		StringBuffer b = new StringBuffer();
		
		int nb = s.length();
		for(int i=0;i<nb;i++) b.append(" ");
		
		return b.toString();
	}
}