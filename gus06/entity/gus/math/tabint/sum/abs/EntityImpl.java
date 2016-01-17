package gus06.entity.gus.math.tabint.sum.abs;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151209";}

	
	public Object t(Object obj) throws Exception
	{
		int[] nn = (int[]) obj;
		int sum = 0;
		for(int n:nn) sum += Math.abs(n);
		return new Integer(sum);
	}
}
