package gus06.entity.gus.convert.objarraytofarray.strict;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151030";}

	
	
	public Object t(Object obj) throws Exception
	{
		if(obj==null) return null;
		
		Object[] oo = (Object[]) obj;
		int number = oo.length;
		
		F[] yy = new F[number];
		for(int i=0;i<number;i++)
		{
			if(!(oo[i] instanceof F)) return null;
			yy[i] = (F) oo[i];
		}
		return yy;
	}
}