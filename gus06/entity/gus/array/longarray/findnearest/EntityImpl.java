package gus06.entity.gus.array.longarray.findnearest;

import gus06.framework.*;
import java.util.List;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160816";}


	private Service findDistance;
	
	public EntityImpl() throws Exception
	{
		findDistance = Outside.service(this,"gus.data.perform.distance");
	}

	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		long[] input = (long[]) o[0];
		Object value = o[1];
		
		Object output = null;
		double dist = Double.MAX_VALUE;
		
		int nb = input.length;
		for(int i=0;i<nb;i++)
		{
			Long element = new Long(input[i]);
			Number d = (Number) findDistance.t(new Object[]{element,value});
			double dist0 = d.doubleValue();
			
			if(dist0<dist)
			{
				dist = dist0;
				output = element;
			}
		}
		return output;
	}
}
