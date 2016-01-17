package gus06.entity.gus.sys.expression1.builder1.pools;

import gus06.framework.*;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151101";}


	private Service toArray;
	
	public EntityImpl() throws Exception
	{
		toArray = Outside.service(this,"gus.find.objectarray");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] array = (Object[]) toArray.t(obj);
		if(array.length>25) throw new Exception("Too many arguments: "+array.length);
		
		Map pool = new HashMap();
		for(int i=0;i<array.length;i++)
		{
			char c = (char) (97+i);
			pool.put(""+c,array[i]);
		}
		
		List pools = new ArrayList();
		pools.add(pool);
		
		return pools;
	}
}
