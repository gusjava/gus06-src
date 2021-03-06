package gus06.entity.gus.string.transform.split.length5.tolines;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160512";}
	
	public static final int LEN = 5;


	public Object t(Object obj) throws Exception
	{
		String s = (String) obj;
		
		StringBuffer b = new StringBuffer();
		for(int i=0;i<s.length();i++)
		{
			b.append(s.charAt(i));
			if((i+1)%LEN==0) b.append("\n");
		}
		
		if(b.length()>0) b.deleteCharAt(b.length()-1);
		return b.toString();
	}
}
