package gus06.entity.gus.math.tabint.normalize.pos;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151209";}


	private Service findMin;


	public EntityImpl() throws Exception
	{
		findMin = Outside.service(this,"gus.math.tabint.min");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		int[] t = (int[]) obj;
		int count = t.length;
		
		Integer min = ((Integer) findMin.t(t)).intValue();
		
		int[] t1 = new int[count];
		for(int i=0;i<count;i++) t1[i] = t[i] + min;
		return t1;
	}
}
