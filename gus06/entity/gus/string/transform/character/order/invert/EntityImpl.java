package gus06.entity.gus.string.transform.character.order.invert;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20141112";}
	
	
	public Object t(Object obj) throws Exception
	{
		StringBuffer b = new StringBuffer((String) obj);
		return b.reverse().toString();
	}
}
