package gus06.entity.gus.math.tablong.stddev;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160705";}

	
	public Object t(Object obj) throws Exception
	{
		long[] t = (long[]) obj;
		int count = t.length;
		
		double sum = 0;
		for(int i=0;i<count;i++) sum += t[i];
		double avg = sum/count;
		
		sum = 0;
		for(int i=0;i<count;i++) sum += Math.pow(t[i]-avg,2);
		double variance = sum/count;
		double stddev = Math.sqrt(variance);
		
		return new Double(stddev);
	}
}
