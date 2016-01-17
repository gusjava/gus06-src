package gus06.entity.gus.math.tabint.sum;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150708";}

	
	public Object t(Object obj) throws Exception
	{
		int[] nn = (int[]) obj;
		int sum = 0;
		for(int n:nn) sum += n;
		return new Integer(sum);
	}
}
