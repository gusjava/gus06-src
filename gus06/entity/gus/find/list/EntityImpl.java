package gus06.entity.gus.find.list;

import gus06.framework.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150530";}
	
	
	public Object t(Object obj) throws Exception
	{
		if(obj instanceof List) return (List) obj;
		if(obj instanceof Set) return new ArrayList((Set) obj);
		if(obj instanceof Object[]) return toList((Object[]) obj);
		return toList(obj);
	}
	
	private List toList(Object[] oo)
	{
		List list = new ArrayList();
		for(Object o:oo) list.add(o);
		return list;
	}
	
	private List toList(Object o)
	{
		List list = new ArrayList();
		list.add(o);
		return list;
	}
}
