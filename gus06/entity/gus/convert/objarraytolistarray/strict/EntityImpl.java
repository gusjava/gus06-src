package gus06.entity.gus.convert.objarraytolistarray.strict;

import gus06.framework.*;
import java.util.List;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151030";}

	
	
	public Object t(Object obj) throws Exception
	{
		if(obj==null) return null;
		
		Object[] oo = (Object[]) obj;
		int length = oo.length;
		
		List[] yy = new List[length];
		for(int i=0;i<length;i++)
		{
			if(!(oo[i] instanceof List)) return null;
			yy[i] = (List) oo[i];
		}
		return yy;
	}
}
