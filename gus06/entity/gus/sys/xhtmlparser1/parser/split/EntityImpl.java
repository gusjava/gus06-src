package gus06.entity.gus.sys.xhtmlparser1.parser.split;

import gus06.framework.*;
import java.util.List;
import java.util.ArrayList;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20170226";}

	
	public Object t(Object obj) throws Exception
	{
		String s = (String) obj;
		
		List list = new ArrayList();
		
		boolean inString = false;
		boolean inTag = false;
		
		StringBuffer b = new StringBuffer();
		
		for(int i=0;i<s.length();i++)
		{
			char c = s.charAt(i);
			if(c=='"')
			{
				if(inTag) inString = !inString;
				b.append(c);
			}
			else if(c=='<')
			{
				if(inString)
				{
					b.append(c);
				}
				else
				{
					inTag = true;
					list.add(b.toString());
					list.add(""+c);
					b = new StringBuffer();
				}
			}
			else if(c=='>')
			{
				if(inString)
				{
					b.append(c);
				}
				else
				{
					inTag = false;
					list.add(b.toString());
					list.add(""+c);
					b = new StringBuffer();
				}
			}
			else b.append(c);
		}
		
		list.add(b.toString());
		return list;
	}
}
