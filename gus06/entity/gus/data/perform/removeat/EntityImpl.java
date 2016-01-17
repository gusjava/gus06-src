package gus06.entity.gus.data.perform.removeat;

import gus06.framework.*;
import java.util.List;
import java.util.Set;
import java.util.Map;

public class EntityImpl implements Entity, P, T {

	public String creationDate() {return "20151205";}
	
	
	private Service performList;
	private Service performSet;
	private Service performMap;
	
	public EntityImpl() throws Exception
	{
		performList = Outside.service(this,"gus.list.removeat");
		performSet = Outside.service(this,"gus.set.removeat");
		performMap = Outside.service(this,"gus.map.removeat");
	}

	
	public void p(Object obj) throws Exception
	{t(obj);}
	
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		Object input = o[0];
		
		if(input instanceof List)
			return performList.t(obj);
		
		if(input instanceof Set)
			return performSet.t(obj);
		
		if(input instanceof Map)
			return performMap.t(obj);
		
		throw new Exception("Invalid data type: "+input.getClass().getName());
	}
}
