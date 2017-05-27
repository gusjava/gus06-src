package gus06.entity.gus.data.perform.collect3;

import gus06.framework.*;
import java.util.List;
import java.util.Set;

public class EntityImpl implements Entity, P, T {

	public String creationDate() {return "20170326";}
	
	
	private Service performList;
	private Service performArray;
	
	
	public EntityImpl() throws Exception
	{
		performList = Outside.service(this,"gus.list.collect3");
		performArray = Outside.service(this,"gus.array.objectarray.collect3");
	}
	
	public void p(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		Object input = o[0];
		
		if(input instanceof List)	{performList.p(obj);return;}
		if(input instanceof Object[]) 	{performArray.p(obj);return;}
		
		throw new Exception("Invalid data type: "+input.getClass().getName());
	}

	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		Object input = o[0];
		
		if(input instanceof List) return performList.t(obj);
		if(input instanceof Object[]) return performArray.t(obj);
		
		throw new Exception("Invalid data type: "+input.getClass().getName());
	}
}
