package gus06.entity.gus.convert.objarraytosetarray.strict;

import gus06.framework.*;
import java.util.Set;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151030";}

	
	
	public Object t(Object obj) throws Exception
	{
		if(obj==null) return null;
		
		Object[] oo = (Object[]) obj;
		int number = oo.length;
		
		Set[] yy = new Set[number];
		for(int i=0;i<number;i++)
		{
			if(!(oo[i] instanceof Set)) return null;
			yy[i] = (Set) oo[i];
		}
		return yy;
	}
}
