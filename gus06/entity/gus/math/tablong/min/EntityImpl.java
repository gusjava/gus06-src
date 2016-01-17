package gus06.entity.gus.math.tablong.min;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151203";}

	
	public Object t(Object obj) throws Exception
	{
		long[] t = (long[]) obj;
		long min = Long.MAX_VALUE;
		int count = t.length;
		
		for(int i=0;i<count;i++) if(t[i]<min) min = t[i];
		return new Long(min);
	}
}
