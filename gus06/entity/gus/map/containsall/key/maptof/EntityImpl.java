package gus06.entity.gus.map.containsall.key.maptof;

import gus06.framework.*;
import java.util.Map;
import java.util.Collection;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160201";}
	
	
	public Object t(Object obj) throws Exception
	{return new F1((Map) obj);}
	
	
	private class F1 implements F
	{
		private Map m;
		public F1(Map m) {this.m = m;}
		
		public boolean f(Object obj) throws Exception
		{
			Collection c0 = (Collection) obj;
			return m.keySet().containsAll(c0);
		}
	}
}
