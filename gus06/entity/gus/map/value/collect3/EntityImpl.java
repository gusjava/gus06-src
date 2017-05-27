package gus06.entity.gus.map.value.collect3;

import gus06.framework.*;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;

public class EntityImpl implements Entity, P, T {

	public String creationDate() {return "20170326";}


	private Service buildMap;
	
	public EntityImpl() throws Exception
	{
		buildMap = Outside.service(this,"gus.map.findall3.buildmap");
	}
	
	
	public void p(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		Map input = (Map) o[0];
		Map output = (Map) t(obj);
		
		input.clear();
		input.putAll(output);
	}
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		Map input = (Map) o[0];
		T t = (T) o[1];
		
		Map output = new HashMap();
		Iterator it = input.keySet().iterator();
		while(it.hasNext())
		{
			Object key = it.next();
			
			Map m = (Map) buildMap.t(new Object[]{input,key});
			output.put(key,t.t(m));
		}
		return output;
	}
}
