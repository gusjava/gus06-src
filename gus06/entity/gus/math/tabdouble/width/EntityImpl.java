package gus06.entity.gus.math.tabdouble.width;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151209";}


	private Service range;


	public EntityImpl() throws Exception
	{
		range = Outside.service(this,"gus.math.tabdouble.range");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		double[] r = (double[]) range.t(obj);
		return new Double(r[1]-r[0]);
	}
}
