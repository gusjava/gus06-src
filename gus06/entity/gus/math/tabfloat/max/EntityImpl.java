package gus06.entity.gus.math.tabfloat.max;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151203";}

	
	public Object t(Object obj) throws Exception
	{
		float[] t = (float[]) obj;
		float max = Float.MIN_VALUE;
		int count = t.length;
		
		for(int i=0;i<count;i++) if(t[i]>max) max = t[i];
		return new Float(max);
	}
}
