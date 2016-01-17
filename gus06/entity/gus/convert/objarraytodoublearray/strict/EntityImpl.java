package gus06.entity.gus.convert.objarraytodoublearray.strict;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151030";}

	
	
	public Object t(Object obj) throws Exception
	{
		if(obj==null) return null;
		
		Object[] oo = (Object[]) obj;
		int number = oo.length;
		
		double[] yy = new double[number];
		for(int i=0;i<number;i++)
		{
			if(!(oo[i] instanceof Number)) return null;
			yy[i] = ((Number) oo[i]).doubleValue();
		}
		return yy;
	}
}