package gus06.entity.gus.feature.op.col.hasevery.mapkey.f;

import gus06.framework.*;
import java.util.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150722";}


	
	public Object t(Object obj) throws Exception
	{return new F1((F) obj);}
	
	
	
	
	private class F1 implements F
	{
		private F f;
		public F1(F f) {this.f = f;}
		
		public boolean f(Object obj) throws Exception
		{
			Map m = (Map) obj;
			Iterator it = m.keySet().iterator();
			while(it.hasNext())
			{
				Object key = it.next();
				if(!f.f(key)) return false;
			}
			return true;
		}
	}
}
