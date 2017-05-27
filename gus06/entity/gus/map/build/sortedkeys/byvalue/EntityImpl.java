package gus06.entity.gus.map.build.sortedkeys.byvalue;

import gus06.framework.*;
import java.util.Map;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;
import java.util.ArrayList;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150923";}
	
	
	public Object t(Object obj) throws Exception
	{
		if(obj instanceof Map) return build((Map) obj);
		throw new Exception("Invalid input data: "+obj.getClass().getName());
	}
	
	
	private List build(Map map)
	{
		List keys = new ArrayList(map.keySet());
		Collections.sort(keys,new Comparator1(map));
		return keys;
	}
	
	
	private class Comparator1 implements Comparator
	{
		private Map map;
		public Comparator1(Map map) {this.map = map;}
		
		public int compare(Object key1, Object key2)
		{
			Comparable value1 = (Comparable) map.get(key1);
			Comparable value2 = (Comparable) map.get(key2);
			return value1.compareTo(value2);
		}
	}
}
