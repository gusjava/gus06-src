package gus06.entity.gus.string.transform.truncate.length5;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150926";}

	public static final int LENGTH = 5;


	public Object t(Object obj) throws Exception
	{
		String s = (String) obj;
		String line = firstNotEmptyLine(s);
		return truncate(line,LENGTH);
	}
	
	private String firstNotEmptyLine(String s)
	{
		String[] n = s.split("\n");
		for(int i=0;i<n.length;i++) if(!n[i].equals("")) return n[i];
		return "";
	}
	
	private String truncate(String s, int n)
	{
		if(s.length()<=n) return s;
		return s.substring(0,n)+"..";
	}
}