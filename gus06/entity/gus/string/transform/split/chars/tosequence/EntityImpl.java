package gus06.entity.gus.string.transform.split.chars.tosequence;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20141105";}


	public Object t(Object obj) throws Exception
	{
		String s = (String) obj;
		
		StringBuffer b = new StringBuffer();
		for(int i=0;i<s.length();i++)
		b.append(s.charAt(i)+";");
		
		if(b.length()>0) b.deleteCharAt(b.length()-1);
		return b.toString();
	}
}
