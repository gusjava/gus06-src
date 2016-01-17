package gus06.entity.gus.find.stringarray;

import gus06.framework.*;
import java.util.*;


public class EntityImpl implements Entity, T {

	public String creationDate() {return "20140910";}

	
	public Object t(Object obj) throws Exception
	{
		if(obj==null) return null;
		if(obj instanceof String[]) return obj;
		if(obj instanceof List) return listToArray((List) obj);
		if(obj instanceof Set) return setToArray((Set) obj);
		if(obj instanceof Map) return mapToArray((Map) obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	
	private String[] listToArray(List list)
	{
		String[] n = new String[list.size()];
		for(int i=0;i<list.size();i++) n[i] = (String) list.get(i);
		return n;
	}
	
	private String[] setToArray(Set set) throws Exception
	{
		ArrayList list = new ArrayList(set);
		Collections.sort(list);
		return listToArray(list);
	}
	
	private String[] mapToArray(Map map) throws Exception
	{
		return setToArray(map.keySet());
	}
}
