package gus06.entity.gus.sys.script1.analyze2.finduntil;

import gus06.framework.*;

public class EntityImpl implements Entity, T {
	
	public static final String V_END = "end";


	public String creationDate() {return "20150829";}

	
	public static final String[] LIST = new String[] {
		"block",
		"code",
		"each",
		"extends",
		"for",
		"function",
		"if",
		"ignore",
		"redirect",
		"repeat",
		"root",
		"try",
		"while",
		"until"
	};
	
	
	
	
	public Object t(Object obj) throws Exception
	{
		String name = (String) obj;
		
		if(inList(name)) return V_END;
		if(name.startsWith("_")) return V_END;
		
		return null;
	}
	
	
	private boolean inList(String name)
	{
		for(String s:LIST) if(s.equals(name)) return true;
		return false;
	}
}