package gus06.manager.gus.gyem.tools;

import gus06.framework.*;
import java.util.*;


public class SupportMap extends S1 implements Map, R, V, T, G, P, F {

	private Map map;
	private String name;
	
	private Object lastElement;
	private Object lastResult;
	private Object lastKey;
	
	
	
	public SupportMap(String name)
	{
		map = new HashMap();
		this.name = name;
	}
	 
	public String toString()
	{return name;}
	
	
	
	
	public int size() 						{return map.size();}
	public boolean isEmpty() 					{return map.isEmpty();}
	public boolean containsKey(Object key) 				{return map.containsKey(key);}
	public boolean containsValue(Object value) 			{return map.containsValue(value);}
	public Set keySet()						{return map.keySet();}
	public Collection values()					{return map.values();}
	public Set entrySet() 						{return map.entrySet();}
	public Object get(Object key)					{return map.get(key);}
	public boolean equals(Object o)					{return map.equals(o);}
	
	
	
	public Object put(Object key, Object value)
	{
		lastKey = key;
		lastElement = value;
		lastResult = map.put(key,value);
		
		send(this,"put(Object,Object)");
		return lastResult;
	}

	
	public Object remove(Object key)
	{
		lastKey = key;
		lastResult = map.remove(key);
		
		if(lastResult!=null)
		send(this,"remove(Object)");
		return lastResult;
	}
	

	public void putAll(Map m)
	{
		map.putAll(m);
		send(this,"putAll(Map)");
	}

	
	public void clear()
	{
		map.clear();
		send(this,"clear()");
	}
	
	


	
	public Object r(String key) throws Exception
	{
		if(key.equals("lastElement")) return lastElement;
		if(key.equals("lastResult")) return lastResult;
		if(key.equals("lastKey")) return lastKey;
		if(key.equals("name")) return name;
		if(key.equals("map")) return map;
		
		if(key.equals("keys"))
			return new String[]{"lastElement","lastResult","lastKey","name","map"};
		
		throw new Exception("Unknown key "+key);
	}
	
	public void v(String key, Object obj) throws Exception
	{
		if(key.equals("lastElement")) {lastElement = obj;return;}
		if(key.equals("lastResult")) {lastResult = obj;return;}
		if(key.equals("lastKey")) {lastKey = obj;return;}
		if(key.equals("name")) {name = (String) obj;return;}
		if(key.equals("map")) {map = (Map) obj;return;}

		throw new Exception("Unknown key "+key);
	}
	
	public boolean f(Object obj) throws Exception 		{return map.containsKey(obj);}
	public Object t(Object obj) throws Exception 		{return map.get(obj);}
	public Object g() throws Exception 			{return map;}
	public void p(Object obj) throws Exception		{map = (Map) obj;}
}