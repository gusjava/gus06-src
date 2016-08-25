package gus06.entity.gus.convert.objarraytoparray.strict;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151030";}


	
	public Object t(Object obj) throws Exception
	{
		if(obj==null) return null;
		
		Object[] oo = (Object[]) obj;
		int length = oo.length;
		
		P[] yy = new P[length];
		for(int i=0;i<length;i++)
		{
			if(!(yy[i] instanceof P)) return null;
			yy[i] = (P) oo[i];
		}
		return yy;
	}
}