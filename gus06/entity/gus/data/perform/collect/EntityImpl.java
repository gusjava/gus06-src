package gus06.entity.gus.data.perform.collect;

import gus06.framework.*;
import java.util.List;
import java.util.Set;
import java.util.Map;

public class EntityImpl implements Entity, P, T {

	public String creationDate() {return "20151117";}
	
	
	private Service performList;
	private Service performSet;
	private Service performMap;
	private Service performArray;
	
	private Service performDoubleArray;
	private Service performFloatArray;
	private Service performIntArray;
	private Service performLongArray;
	
	
	public EntityImpl() throws Exception
	{
		performList = Outside.service(this,"gus.list.collect");
		performSet = Outside.service(this,"gus.set.collect");
		performMap = Outside.service(this,"gus.map.value.collect");
		performArray = Outside.service(this,"gus.array.objectarray.collect");
		
		performDoubleArray = Outside.service(this,"gus.array.doublearray.collect");
		performFloatArray = Outside.service(this,"gus.array.floatarray.collect");
		performIntArray = Outside.service(this,"gus.array.intarray.collect");
		performLongArray = Outside.service(this,"gus.array.longarray.collect");
	}
	
	public void p(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		Object input = o[0];
		
		if(input instanceof List)	{performList.p(obj);return;}
		if(input instanceof Set)	{performSet.p(obj);return;}
		if(input instanceof Map) 	{performMap.p(obj);return;}
		if(input instanceof Object[]) 	{performArray.p(obj);return;}
		
		if(input instanceof double[]) 	{performDoubleArray.p(obj);return;}
		if(input instanceof float[]) 	{performFloatArray.p(obj);return;}
		if(input instanceof int[]) 	{performIntArray.p(obj);return;}
		if(input instanceof long[])	{performLongArray.p(obj);return;}
		
		throw new Exception("Invalid data type: "+input.getClass().getName());
	}

	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		Object input = o[0];
		
		if(input instanceof List) return performList.t(obj);
		if(input instanceof Set) return performSet.t(obj);
		if(input instanceof Map) return performMap.t(obj);
		if(input instanceof Object[]) return performArray.t(obj);
		
		if(input instanceof double[]) return performDoubleArray.t(obj);
		if(input instanceof float[]) return performFloatArray.t(obj);
		if(input instanceof int[]) return performIntArray.t(obj);
		if(input instanceof long[]) return performLongArray.t(obj);
		
		throw new Exception("Invalid data type: "+input.getClass().getName());
	}
}
