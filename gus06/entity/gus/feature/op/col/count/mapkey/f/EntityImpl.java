package gus06.entity.gus.feature.op.col.count.mapkey.f;

import gus06.framework.*;
import java.util.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151119";}


	
	public Object t(Object obj) throws Exception
	{return new T1((F) obj);}
	
	
	
	
	private class T1 implements T
	{
		private F f;
		public T1(F f) {this.f = f;}
		
		public Object t(Object obj) throws Exception
		{
			Map m = (Map) obj;
			int count = 0;
			
			Iterator it = m.keySet().iterator();
			while(it.hasNext())
			{
				Object key = it.next();
				if(f.f(key)) count++;
			}
			return new Integer(count);
		}
	}
}
