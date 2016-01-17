package gus06.entity.gus.math.tabfloat.sum;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151203";}

	
	public Object t(Object obj) throws Exception
	{
		float[] dd = (float[]) obj;
		float sum = 0;
		for(float d:dd) sum += d;
		return new Float(sum);
	}
}
