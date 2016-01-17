package gus06.entity.gus.convert.objarraytorarray.strict;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151203";}

	
	
	public Object t(Object obj) throws Exception
	{
		if(obj==null) return null;
		
		Object[] oo = (Object[]) obj;
		int number = oo.length;
		
		R[] yy = new R[number];
		for(int i=0;i<number;i++)
		{
			if(!(oo[i] instanceof R)) return null;
			yy[i] = (R) oo[i];
		}
		return yy;
	}
}