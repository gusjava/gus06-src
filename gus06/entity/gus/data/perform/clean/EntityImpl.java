package gus06.entity.gus.data.perform.clean;

import gus06.framework.*;
import java.util.List;
import java.util.Set;
import java.util.Map;

public class EntityImpl implements Entity, T, P {

	public String creationDate() {return "20170201";}


	private Service performMap;
	private Service performList;
	private Service performSet;
	private Service performString;
	
	public EntityImpl() throws Exception
	{
		performMap = Outside.service(this,"gus.map.clean");
		performList = Outside.service(this,"gus.list.clean");
		performSet = Outside.service(this,"gus.set.clean");
		performString = Outside.service(this,"gus.string.transform.line.trim.andremoveblank");
	}

	
	
	public Object t(Object obj) throws Exception
	{
		if(obj instanceof Map) return performMap.t(obj);
		if(obj instanceof List) return performList.t(obj);
		if(obj instanceof Set) return performSet.t(obj);
		if(obj instanceof String) return performString.t(obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	
	public void p(Object obj) throws Exception
	{
		if(obj instanceof Map) {performMap.p(obj);return;}
		if(obj instanceof List) {performList.p(obj);return;}
		if(obj instanceof Set) {performSet.t(obj);return;}
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
}
