package gus06.entity.gus.math.tabfloat.product;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151203";}

	
	public Object t(Object obj) throws Exception
	{
		float[] dd = (float[]) obj;
		float product = 1;
		for(float d:dd) product *= d;
		return new Float(product);
	}
}
