package gus06.entity.gus.math.tabdouble.product;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151030";}

	
	public Object t(Object obj) throws Exception
	{
		double[] dd = (double[]) obj;
		double product = 1;
		for(double d:dd) product *= d;
		return new Double(product);
	}
}
