package gus06.entity.gus.math.tabdouble.sum.abs;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151209";}

	
	public Object t(Object obj) throws Exception
	{
		double[] dd = (double[]) obj;
		double sum = 0;
		for(double d:dd) sum += Math.abs(d);
		return new Double(sum);
	}
}
