package gus06.entity.gus.data.compare.string.comparator2.distance;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160806";}


	private Service perform;

	public EntityImpl() throws Exception
	{
		perform = Outside.service(this,"gus.data.compare.string.comparator2");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		Double d = (Double) perform.t(obj);
		return new Double(1-d.doubleValue());
	}
}