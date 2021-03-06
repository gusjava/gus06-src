package gus06.entity.gus.array.objectarray.findall3;

import gus06.framework.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20170112";}


	private Service buildMap;
	
	public EntityImpl() throws Exception
	{
		buildMap = Outside.service(this,"gus.array.objectarray.findall3.buildmap");
	}

	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		Object[] input = (Object[]) o[0];
		F filter = (F) o[1];
		
		int nb = input.length;
		List output = new ArrayList();
		
		for(int i=0;i<nb;i++)
		{
			Integer index = new Integer(i);
			Map m = (Map) buildMap.t(new Object[]{input,index});
			if(filter.f(m)) output.add(input[i]);
		}
		return output;
	}
}
