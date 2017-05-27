package gus06.entity.gus.string.transform.format.character.special;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160503";}

	
	
	public Object t(Object obj) throws Exception
	{
		String s = (String) obj;
		
		return s
			.replace("<->","\u2194")
			.replace("<-","\u2190")
			.replace("->","\u2192")
			
			.replace("<=>","\u21d4")
			.replace("<=","\u21d0")
			.replace("=>","\u21d2")
			
			.replace("(c)","\u00A9")
			.replace("OE","\u0152")
			.replace("oe","\u0153")
			.replace("AE","\u00c6")
			.replace("ae","\u00e6")
			
			.replace("1/4","\u00bc")
			.replace("1/2","\u00bd")
			.replace("3/4","\u00be")
			
			.replace("[]","\u2751")
			.replace("*","\u2022")
			
			.replace("(1)","\u2780")
			.replace("(2)","\u2781")
			.replace("(3)","\u2782")
			.replace("(4)","\u2783")
			.replace("(5)","\u2784")
			.replace("(6)","\u2785")
			.replace("(7)","\u2786")
			.replace("(8)","\u2787")
			.replace("(9)","\u2788")
			.replace("(10)","\u2789")
		;
	}
}