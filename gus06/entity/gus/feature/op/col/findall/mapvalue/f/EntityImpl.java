package gus06.entity.gus.feature.op.col.findall.mapvalue.f;

import gus06.framework.*;
import java.util.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150722";}


	
	public Object t(Object obj) throws Exception
	{return new T1((F) obj);}
	
	
	
	
	private class T1 implements T
	{
		private F f;
		public T1(F f) {this.f = f;}
		
		public Object t(Object obj) throws Exception
		{
			Map m = (Map) obj;
			Map r = new HashMap();
			
			Iterator it = m.keySet().iterator();
			while(it.hasNext())
			{
				Object key = it.next();
				Object value = m.get(key);
				
				if(f.f(value)) r.put(key,value);
			}
			return r;
		}
	}
}
