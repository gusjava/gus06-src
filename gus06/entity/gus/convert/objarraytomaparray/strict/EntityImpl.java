package gus06.entity.gus.convert.objarraytomaparray.strict;

import gus06.framework.*;
import java.util.Map;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151118";}

	
	
	public Object t(Object obj) throws Exception
	{
		if(obj==null) return null;
		
		Object[] oo = (Object[]) obj;
		int number = oo.length;
		
		Map[] yy = new Map[number];
		for(int i=0;i<number;i++)
		{
			if(!(oo[i] instanceof Map)) return null;
			yy[i] = (Map) oo[i];
		}
		return yy;
	}
}
