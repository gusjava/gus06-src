package gus06.entity.gus.string.transform.format.character.special;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160503";}


	public EntityImpl() throws Exception
	{
	}
	
	
	public Object t(Object obj) throws Exception
	{
		String s = (String) obj;
		
		s = s.replace("<->","\u2194")
			.replace("->","\u2192")
			.replace("<-","\u2190")
			.replace("(c)","\u00A9")
			.replace("OE","\u0152")
			.replace("oe","\u0153")
			.replace("AE","\u01fc")
			.replace("1/4","\u00bc")
			.replace("1/2","\u00bd")
			.replace("3/4","\u00be")
			.replace("[]","\u2751")
			.replace("*","\u2022")
		;
		
		return s;
	}
}