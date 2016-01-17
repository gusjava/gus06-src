package gus06.entity.gus.convert.objarraytotarray.strict;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151030";}

	
	
	public Object t(Object obj) throws Exception
	{
		if(obj==null) return null;
		
		Object[] oo = (Object[]) obj;
		int number = oo.length;
		
		T[] yy = new T[number];
		for(int i=0;i<number;i++)
		{
			if(!(oo[i] instanceof T)) return null;
			yy[i] = (T) oo[i];
		}
		return yy;
	}
}