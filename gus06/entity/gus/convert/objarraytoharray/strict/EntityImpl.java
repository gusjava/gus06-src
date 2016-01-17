package gus06.entity.gus.convert.objarraytoharray.strict;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151030";}

	
	
	public Object t(Object obj) throws Exception
	{
		if(obj==null) return null;
		
		Object[] oo = (Object[]) obj;
		int number = oo.length;
		
		H[] yy = new H[number];
		for(int i=0;i<number;i++)
		{
			if(!(oo[i] instanceof H)) return null;
			yy[i] = (H) oo[i];
		}
		return yy;
	}
}