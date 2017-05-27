package gus06.entity.gus.string.indexof.first;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160904";}

	
	
	public Object t(Object obj) throws Exception
	{
		String[] o = (String[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		String str = o[0];
		String findStr = o[1];
		
		int index = str.indexOf(findStr);
		return index==-1 ? null : new Integer(index);
	}
}
