package gus06.entity.gus.data.perform.mapvalue;

import gus06.framework.*;
import java.util.List;
import java.util.Set;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151119";}
	
	
	private Service performList;
	private Service performSet;
	private Service performArray;
	
	
	public EntityImpl() throws Exception
	{
		performList = Outside.service(this,"gus.list.mapvalue");
		performSet = Outside.service(this,"gus.set.mapvalue");
		performArray = Outside.service(this,"gus.array.objectarray.mapvalue");
	}	
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		Object input = o[0];
		
		if(input instanceof List) return performList.t(obj);
		if(input instanceof Set) return performSet.t(obj);
		if(input instanceof Object[]) return performArray.t(obj);
		
		throw new Exception("Invalid data type: "+input.getClass().getName());
	}
}
