package gus06.entity.gus.math.tabdouble.normalize.norm1;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151210";}


	private Service range;


	public EntityImpl() throws Exception
	{
		range = Outside.service(this,"gus.math.tabint.range");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		double[] t = (double[]) obj;
		int count = t.length;
		
		double[] r = (double[]) range.t(t);
		double min = r[0];
		double max = r[1];
		
		double[] t1 = new double[count];
		for(int i=0;i<count;i++) t1[i] = (t[i] - min)/(max - min);
		return t1;
	}
}
