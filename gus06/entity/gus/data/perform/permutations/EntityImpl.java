package gus06.entity.gus.data.perform.permutations;

import gus06.framework.*;
import java.util.List;
import java.util.Set;
import java.util.ArrayList;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20170424";}


	private Service performString;
	private Service performList;


	public EntityImpl() throws Exception
	{
		performString = Outside.service(this,"gus.string.perform.permutations");
		performList = Outside.service(this,"gus.list.perform.permutations");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		if(obj==null) return null;
		
		if(obj instanceof String) return performString.t(obj);
		if(obj instanceof List) return performList.t(obj);
		if(obj instanceof Set) return performList.t(toList((Set) obj));
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	
	private List toList(Set set)
	{return new ArrayList(set);}
}
