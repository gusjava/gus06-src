package gus06.entity.gus.string.indexof.all;

import gus06.framework.*;
import java.util.List;
import java.util.ArrayList;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160904";}

	
	
	public Object t(Object obj) throws Exception
	{
		String[] o = (String[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		String str = o[0];
		String findStr = o[1];
		
		List list = new ArrayList();
		
		int index = 0;

		while(index != -1)
		{
			index = str.indexOf(findStr,index);
			list.add(new Integer(index));
			
			if(index != -1)
			index += findStr.length();
		}

		return list;
	}
}
