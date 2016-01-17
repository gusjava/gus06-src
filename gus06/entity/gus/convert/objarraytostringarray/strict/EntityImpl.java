package gus06.entity.gus.convert.objarraytostringarray.strict;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151201";}

	
	
	public Object t(Object obj) throws Exception
	{
		if(obj==null) return null;
		
		Object[] oo = (Object[]) obj;
		int number = oo.length;
		
		String[] yy = new String[number];
		for(int i=0;i<number;i++)
		{
			if(!(oo[i] instanceof String)) return null;
			yy[i] = (String) oo[i];
		}
		return yy;
	}
}
