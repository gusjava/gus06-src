package gus06.entity.gus.math.tabint.width;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151209";}


	private Service range;


	public EntityImpl() throws Exception
	{
		range = Outside.service(this,"gus.math.tabint.range");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		int[] r = (int[]) range.t(obj);
		return new Integer(r[1]-r[0]);
	}
}
