package gus06.entity.gus.string.count.substrings_i;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160808";}

	
	
	public Object t(Object obj) throws Exception
	{
		String[] o = (String[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		String str = o[0].toLowerCase();
		String findStr = o[1].toLowerCase();
		
		int lastIndex = 0;
		int count = 0;

		while(lastIndex != -1)
		{
			lastIndex = str.indexOf(findStr,lastIndex);
			if(lastIndex != -1)
			{
				count ++;
				lastIndex += findStr.length();
			}
		}

		return new Integer(count);
	}
}