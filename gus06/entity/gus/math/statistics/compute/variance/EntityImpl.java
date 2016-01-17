package gus06.entity.gus.math.statistics.compute.variance;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150516";}

	
	public Object t(Object obj) throws Exception
	{
		double[] t = (double[]) obj;
		double sum = 0;
		int count = t.length;
		
		for(int i=0;i<count;i++) sum += t[i];
		double mean = sum/count;
		
		double variance = 0;
		for(int i=0;i<count;i++)
		{
			double d = t[i]-mean;
			variance += d*d;
		}
		return new Double(variance);
	}
}
