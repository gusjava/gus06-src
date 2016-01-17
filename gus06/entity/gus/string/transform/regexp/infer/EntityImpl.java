package gus06.entity.gus.string.transform.regexp.infer;

import gus06.framework.*;
import java.util.regex.Pattern;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20141105";}

	
	
	public Object t(Object obj) throws Exception
	{
		String s = (String) obj;
		
		if(s.startsWith("(") && s.endsWith(")")) return "\\([^\\)]*\\)";
		if(s.startsWith("[") && s.endsWith("]")) return "\\[[^\\]]*\\]";
		if(s.startsWith("{") && s.endsWith("}")) return "\\{[^\\}]*\\}";
		if(s.startsWith("<") && s.endsWith(">")) return "<[^>]*>";
		if(s.startsWith("\"") && s.endsWith("\"")) return "\"[^\"]*\"";
		if(s.startsWith("\'") && s.endsWith("\'")) return "\'[^\']*\'";
		
		if(isInt(s)) return "[0-9]+";
		
		StringBuffer b = new StringBuffer();
		for(int i=0;i<s.length();i++)
		b.append(handleChar(s.charAt(i)));
		return b.toString();
	}
	
	
	private String handleChar(char c)
	{
		if(Character.isDigit(c)) return ""+c;
		if(Character.isLetter(c)) return "["+Character.toLowerCase(c)+Character.toUpperCase(c)+"]";
		return ".";
	}
	
	
	private boolean isInt(String s)
	{
		try{Integer.parseInt(s);return true;}
		catch(NumberFormatException e){}
		return false;
	}
}
