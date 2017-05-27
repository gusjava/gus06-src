package gus06.entity.gus.sys.expression1.apply.op._distmatrix_str1;

import gus06.framework.*;
import java.util.List;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20170112";}


	private Service distance;
	private Service computeMatrix;

	public EntityImpl() throws Exception
	{
		distance = Outside.service(this,"gus.data.compare.string.comparator1.distance");
		computeMatrix = Outside.service(this,"gus.math.distance.compute.matrix");
	}

	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return null;
		
		if(obj instanceof List) return computeMatrix.t(new Object[]{obj,distance});
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
}
