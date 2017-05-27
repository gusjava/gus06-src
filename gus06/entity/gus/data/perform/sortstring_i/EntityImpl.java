package gus06.entity.gus.data.perform.sortstring_i;

import gus06.framework.*;
import java.util.List;
import java.util.Collections;
import java.util.Set;
import java.util.ArrayList;

public class EntityImpl implements Entity, P, T {

	public String creationDate() {return "20170111";}
	
	
	private Service findList;
	private Service performSort;
	
	public EntityImpl() throws Exception
	{
		findList = Outside.service(this,"gus.find.list");
		performSort = Outside.service(this,"gus.collection.comparator.tostring_i.sort");
	}
	
	
	public void p(Object obj) throws Exception
	{
		if(obj instanceof List) {sort((List) obj);return;}
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	
	public Object t(Object obj) throws Exception
	{
		if(obj instanceof List) return sort(new ArrayList((List) obj));
		
		if(obj instanceof Set) return sort(obj);
		if(obj instanceof Object[]) return sort(obj);
		if(obj instanceof int[]) return sort(obj);
		if(obj instanceof short[]) return sort(obj);
		if(obj instanceof long[]) return sort(obj);
		if(obj instanceof double[]) return sort(obj);
		if(obj instanceof float[]) return sort(obj);
		if(obj instanceof boolean[]) return sort(obj);
		if(obj instanceof char[]) return sort(obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	
	
	
	private List sort(List list) throws Exception
	{
		performSort.p(list);
		return list;
	}
	
	private List sort(Object obj) throws Exception
	{return sort(toList(obj));}
	
	private List toList(Object obj) throws Exception
	{return (List) findList.t(obj);}
}
