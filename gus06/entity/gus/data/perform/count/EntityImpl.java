package gus06.entity.gus.data.perform.count;

import gus06.framework.*;
import java.util.Map;
import java.util.List;
import java.util.Set;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20170118";}


	private Service performList;
	private Service performSet;
	private Service findList;
	
	
	public EntityImpl() throws Exception
	{
		performList = Outside.service(this,"gus.list.count");
		performSet = Outside.service(this,"gus.set.count");
		findList = Outside.service(this,"gus.find.list");
	}

	
	public Object t(Object obj) throws Exception
	{
		if(obj instanceof List) return performList.t(obj);
		if(obj instanceof Set) return performSet.t(obj);
		
		if(obj instanceof Object[]) return performList.t(findList.t(obj));
		if(obj instanceof int[]) return performList.t(findList.t(obj));
		if(obj instanceof short[]) return performList.t(findList.t(obj));
		if(obj instanceof long[]) return performList.t(findList.t(obj));
		if(obj instanceof double[]) return performList.t(findList.t(obj));
		if(obj instanceof float[]) return performList.t(findList.t(obj));
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
}
