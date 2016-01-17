package gus06.entity.gus.math.tablong.sum;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151203";}

	
	public Object t(Object obj) throws Exception
	{
		long[] nn = (long[]) obj;
		long sum = 0;
		for(long n:nn) sum += n;
		return new Long(sum);
	}
}
