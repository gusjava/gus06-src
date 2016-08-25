package gus06.entity.gus.math.tabfloat.mean;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160705";}

	
	public Object t(Object obj) throws Exception
	{
		float[] t = (float[]) obj;
		float sum = 0;
		int count = t.length;
		
		for(int i=0;i<count;i++) sum += t[i];
		return new Float(sum/count);
	}
}
