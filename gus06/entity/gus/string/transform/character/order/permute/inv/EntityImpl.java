package gus06.entity.gus.string.transform.character.order.permute.inv;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20141112";}
	
	
	public Object t(Object obj) throws Exception
	{
		String s = (String) obj;
		if(s.equals("")) return "";
		return s.substring(1) + s.substring(0,1);
	}
}