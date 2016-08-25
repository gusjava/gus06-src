package gus06.entity.gus.data.perform.findall2;

import gus06.framework.*;
import java.util.Map;
import java.util.List;
import java.util.Set;
import java.io.File;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160808";}
	
	
	private Service performList;
	private Service performSet;
	private Service performMap;
	private Service performDir;
	private Service performArray;
	private Service performDoubleArray;
	private Service performIntArray;
	
	
	public EntityImpl() throws Exception
	{
		performList = Outside.service(this,"gus.list.findall2");
		performSet = Outside.service(this,"gus.set.findall2");
		performMap = Outside.service(this,"gus.map.key.findall2");
		performDir = Outside.service(this,"gus.dir.findall2");
		performArray = Outside.service(this,"gus.array.objectarray.findall2");
		performDoubleArray = Outside.service(this,"gus.array.doublearray.findall2");
		performIntArray = Outside.service(this,"gus.array.intarray.findall2");
	}	
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		Object input = o[0];
		
		if(input instanceof List) return performList.t(obj);
		if(input instanceof Set) return performSet.t(obj);
		if(input instanceof Map) return performMap.t(obj);
		if(input instanceof File) return performDir.t(obj);
		if(input instanceof Object[]) return performArray.t(obj);
		if(input instanceof double[]) return performDoubleArray.t(obj);
		if(input instanceof int[]) return performIntArray.t(obj);
		
		throw new Exception("Invalid data type: "+input.getClass().getName());
	}
}
