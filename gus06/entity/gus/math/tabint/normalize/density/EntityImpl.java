package gus06.entity.gus.math.tabint.normalize.density;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151209";}


	private Service sumAbs;


	public EntityImpl() throws Exception
	{
		sumAbs = Outside.service(this,"gus.math.tabint.sum.abs");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		int[] t = (int[]) obj;
		int count = t.length;
		
		double sum = ((Integer) sumAbs.t(t)).doubleValue();
		
		double[] t1 = new double[count];
		for(int i=0;i<count;i++) t1[i] = t[i]/sum;
		return t1;
	}
}
