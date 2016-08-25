package gus06.entity.gus.sys.script1.tool.names.optionarray;

import gus06.framework.*;
import java.util.Map;

public class EntityImpl implements Entity, G, F {

	public String creationDate() {return "20160729";}
	
	public static final String[] OPTIONS = new String[]{
		"after","alter","args",
		"before",
		"debug","deep","if",
		"max","min","op",
		"redirect","repeat","return",
		"skip","keep","sort",
		"until","var","while"};

	
	public Object g() throws Exception
	{
		return OPTIONS;
	}
	
	
	public boolean f(Object obj) throws Exception
	{
		String s = (String) obj;
		for(String name:OPTIONS) if(name.equals(s)) return true;
		return false;
	}
}
