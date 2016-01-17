package gus06.entity.gus.math.tabdouble.mean;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151230";}

	
	public Object t(Object obj) throws Exception
	{
		double[] t = (double[]) obj;
		double sum = 0;
		int count = t.length;
		
		for(int i=0;i<count;i++) sum += t[i];
		return new Double(sum/count);
	}
}
