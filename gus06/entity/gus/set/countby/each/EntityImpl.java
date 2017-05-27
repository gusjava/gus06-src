package gus06.entity.gus.set.countby.each;

import gus06.framework.*;
import java.util.Set;
import java.util.HashMap;
import java.util.Map;
import java.util.Collection;
import java.util.Iterator;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20170212";}


	private Service append;
	
	public EntityImpl() throws Exception
	{
		append = Outside.service(this,"gus.map.freqmap.append");
	}

	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		Set input = (Set) o[0];
		T t = (T) o[1];
		
		Map output = new HashMap();
		for(Object elem:input)
		{
			Collection c = (Collection) t.t(elem);
			if(c!=null)
			{
				Iterator it = c.iterator();
				while(it.hasNext()) append.p(new Object[]{output,it.next()});
			}
		}
		return output;
	}
}
