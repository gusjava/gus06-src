package gus06.entity.gus.math.tabdouble.min;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150708";}

	
	public Object t(Object obj) throws Exception
	{
		double[] t = (double[]) obj;
		double min = Double.MAX_VALUE;
		int count = t.length;
		
		for(int i=0;i<count;i++) if(t[i]<min) min = t[i];
		return new Double(min);
	}
}
