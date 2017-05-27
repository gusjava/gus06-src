package gus06.entity.gus.sys.base1.compute.allvalues2.forfield;

import gus06.framework.*;
import java.util.Map;
import java.util.Set;
import java.util.Iterator;
import java.util.HashSet;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20170507";}

	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		G g = (G) o[0];
		R r = (R) o[0];
		
		String field = (String) o[1];
		
		Set values = new HashSet();
		Object lock = r.r("source");
		
		synchronized(lock)
		{
			Set ids = (Set) g.g();
			Iterator it = ids.iterator();
			while(it.hasNext())
			{
				String id = (String) it.next();
				Map map = (Map) r.r("map_"+id);
				if(map!=null && map.containsKey(field))
				{
					String value = (String) map.get(field);
					String[] nn = value.split(";");
					for(String n:nn) values.add(n);
				}
			}
		}
		
		return values;
	}
}
