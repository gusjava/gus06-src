package gus06.entity.gus.filter.map.build.orfields;

import java.util.Iterator;
import java.util.Map;
import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150529";}


	public Object t(Object obj) throws Exception
	{return new FOrMap((Map)obj);}


	
	private class FOrMap implements F
	{
		private Map map;
		public FOrMap(Map map) {this.map = map;}
		
		public boolean f(Object obj) throws Exception
		{
			Map m = (Map) obj;
			Iterator it = m.keySet().iterator();
			while(it.hasNext())
			{
				Object key = it.next();
				if(map.containsKey(key))
				{
					F f = (F) map.get(key);
					Object value = m.get(key);
					if(f.f(value)) return true;
				}
			}
			return false;
		}
	}
}
