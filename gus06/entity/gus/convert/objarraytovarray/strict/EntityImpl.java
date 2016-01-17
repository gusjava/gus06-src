package gus06.entity.gus.convert.objarraytovarray.strict;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151203";}

	
	
	public Object t(Object obj) throws Exception
	{
		if(obj==null) return null;
		
		Object[] oo = (Object[]) obj;
		int number = oo.length;
		
		V[] yy = new V[number];
		for(int i=0;i<number;i++)
		{
			if(!(oo[i] instanceof V)) return null;
			yy[i] = (V) oo[i];
		}
		return yy;
	}
}