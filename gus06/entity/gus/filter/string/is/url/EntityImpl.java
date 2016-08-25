package gus06.entity.gus.filter.string.is.url;

import gus06.framework.*;

public class EntityImpl implements Entity, F {

	public String creationDate() {return "20160611";}
	
	public static final String KEY_URL = "url";


	private Service regexFromRule;
	private String regex;
	
	public EntityImpl() throws Exception
	{
		regexFromRule = Outside.service(this,"gus.string.transform.regexp.fromrule");
		regex = (String) regexFromRule.r(KEY_URL);
	}

	
	public boolean f(Object obj) throws Exception
	{
		String s = (String) obj;
		return s.matches(regex);
	}
}
