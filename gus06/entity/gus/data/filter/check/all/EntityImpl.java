package gus06.entity.gus.data.filter.check.all;

import gus06.framework.*;
import java.util.Map;
import java.util.List;
import java.util.Set;
import java.io.File;

public class EntityImpl implements Entity, F {

	public String creationDate() {return "20160805";}
	
	
	private Service filterList;
	private Service filterSet;
	private Service filterMap;
	
	//private Service filterDir;
	//private Service filterArray;
	//private Service filterDoubleArray;
	//private Service filterIntArray;
	
	
	public EntityImpl() throws Exception
	{
		filterList = Outside.service(this,"gus.list.check.all");
		filterSet = Outside.service(this,"gus.set.check.all");
		filterMap = Outside.service(this,"gus.map.key.check.all");
		
		//filterDir = Outside.service(this,"gus.dir.findall");
		//filterArray = Outside.service(this,"gus.array.objectarray.findall");
		//filterDoubleArray = Outside.service(this,"gus.array.doublearray.findall");
		//filterIntArray = Outside.service(this,"gus.array.intarray.findall");
	}	
	
	
	public boolean f(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		Object input = o[0];
		
		if(input instanceof List) return filterList.f(obj);
		if(input instanceof Set) return filterSet.f(obj);
		if(input instanceof Map) return filterMap.f(obj);
		//if(input instanceof File) return filterDir.f(obj);
		//if(input instanceof Object[]) return filterArray.f(obj);
		//if(input instanceof double[]) return filterDoubleArray.f(obj);
		//if(input instanceof int[]) return filterIntArray.f(obj);
		
		throw new Exception("Invalid data type: "+input.getClass().getName());
	}
}
