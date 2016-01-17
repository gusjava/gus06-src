package gus06.entity.gus.feature.op.col.trans.mapkey.t;

import gus06.framework.*;
import java.util.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150722";}


	
	public Object t(Object obj) throws Exception
	{return new T1((T) obj);}
	
	
	
	
	private class T1 implements T
	{
		private T t;
		public T1(T t) {this.t = t;}
		
		public Object t(Object obj) throws Exception
		{
			Map m = (Map) obj;
			Map r = new HashMap();
			
			Iterator it = m.keySet().iterator();
			while(it.hasNext())
			{
				Object key = it.next();
				Object value = m.get(key);
				
				r.put(t.t(key),value);
			}
			return r;
		}
	}
}
