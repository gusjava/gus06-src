package gus06.entity.gus.filter.string.palindrome;

import gus06.framework.*;

public class EntityImpl implements Entity, F {

	public String creationDate() {return "20150705";}

	
	public boolean f(Object obj) throws Exception
	{
		String s = (String) obj;
		String s_ = new StringBuffer(s).reverse().toString();
		
		return s.equals(s_);
	}
}
