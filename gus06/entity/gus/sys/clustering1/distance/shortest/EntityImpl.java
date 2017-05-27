package gus06.entity.gus.sys.clustering1.distance.shortest;

import gus06.framework.*;
import java.util.List;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20170108";}


	private Service findShortest;
	private Service distance;

	public EntityImpl() throws Exception
	{
		findShortest = Outside.service(this,"gus.math.distance.find.shortest");
		distance = Outside.service(this,"gus.math.tabdouble.d2.distance.euclidean");
	}
	
	public Object t(Object obj) throws Exception
	{
		List list = (List) obj;
		return findShortest.t(new Object[]{list,distance});
	}
}
