package gus06.entity.gus.string.transform.sequence.trim.end;

import gus06.framework.*;
import java.util.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160510";}
	
	public static final String DELIM = ";";
	public static final String WHITE = " \t\n\r";
	
	
	public Object t(Object obj) throws Exception
	{
		String s = (String) obj;
		String[] n = s.split(DELIM,-1);
		
		StringBuffer b = new StringBuffer();
		
		for(int i=0;i<n.length;i++)
		b.append(trim(n[i])+DELIM);
		
		if(b.length()>0) b.deleteCharAt(b.length()-1);
		return b.toString();
	}
	
	
	
	private String trim(String s)
	{
		int offset = findLast(s);
		return s.substring(0,offset+1);
	}
	
	private int findLast(String s)
	{
		int i = s.length()-1;
		while(WHITE.indexOf(s.charAt(i))>=0) i--;
		return i;
	}
}
