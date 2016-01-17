package gus06.entity.gus.math.tabint.min;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150708";}

	
	public Object t(Object obj) throws Exception
	{
		int[] t = (int[]) obj;
		int min = Integer.MAX_VALUE;
		int count = t.length;
		
		for(int i=0;i<count;i++) if(t[i]<min) min = t[i];
		return new Integer(min);
	}
}
