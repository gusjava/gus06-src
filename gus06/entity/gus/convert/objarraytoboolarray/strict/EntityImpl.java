package gus06.entity.gus.convert.objarraytoboolarray.strict;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151030";}

	
	
	public Object t(Object obj) throws Exception
	{
		if(obj==null) return null;
		
		Object[] oo = (Object[]) obj;
		int length = oo.length;
		
		boolean[] yy = new boolean[length];
		for(int i=0;i<length;i++)
		{
			if(!(oo[i] instanceof Boolean)) return null;
			yy[i] = ((Boolean) oo[i]).booleanValue();
		}
		return yy;
	}
}