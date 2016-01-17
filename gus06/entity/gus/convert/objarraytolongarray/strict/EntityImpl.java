package gus06.entity.gus.convert.objarraytolongarray.strict;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151203";}

	
	
	public Object t(Object obj) throws Exception
	{
		if(obj==null) return null;
		
		Object[] oo = (Object[]) obj;
		int number = oo.length;
		
		long[] yy = new long[number];
		for(int i=0;i<number;i++)
		{
			if(!(oo[i] instanceof Long)) return null;
			yy[i] = ((Long) oo[i]).longValue();
		}
		return yy;
	}
}