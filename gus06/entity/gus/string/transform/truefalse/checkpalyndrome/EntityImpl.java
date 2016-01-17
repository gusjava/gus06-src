package gus06.entity.gus.string.transform.truefalse.checkpalyndrome;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150927";}
	
	public Object t(Object obj) throws Exception
	{
		String s = (String) obj;
		StringBuffer b = new StringBuffer(s);
		boolean isPal = b.reverse().toString().equals(s);
		return ""+isPal;
	}
}
