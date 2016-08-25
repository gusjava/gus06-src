package gus06.entity.gus.convert.objarraytonumberarray.strict;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160802";}

	
	
	public Object t(Object obj) throws Exception
	{
		if(obj==null) return null;
		
		Object[] oo = (Object[]) obj;
		int length = oo.length;
		
		Number[] nn = new Number[length];
		for(int i=0;i<length;i++)
		{
			if(!(oo[i] instanceof Number)) return null;
			nn[i] = (Number) oo[i];
		}
		return nn;
	}
}