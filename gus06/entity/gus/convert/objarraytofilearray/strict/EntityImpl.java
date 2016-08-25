package gus06.entity.gus.convert.objarraytofilearray.strict;

import gus06.framework.*;
import java.io.File;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151201";}

	
	
	public Object t(Object obj) throws Exception
	{
		if(obj==null) return null;
		
		Object[] oo = (Object[]) obj;
		int length = oo.length;
		
		File[] yy = new File[length];
		for(int i=0;i<length;i++)
		{
			if(!(oo[i] instanceof File)) return null;
			yy[i] = (File) oo[i];
		}
		return yy;
	}
}
