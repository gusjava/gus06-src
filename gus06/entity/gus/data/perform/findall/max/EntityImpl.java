package gus06.entity.gus.data.perform.findall.max;

import gus06.framework.*;
import java.util.Map;
import java.util.List;
import java.util.Set;
import java.io.File;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160820";}
	
	
	private Service performList;
	private Service performSet;
	
	
	public EntityImpl() throws Exception
	{
		performList = Outside.service(this,"gus.list.findall.max");
		performSet = Outside.service(this,"gus.set.findall.max");
	}	
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		Object input = o[0];
		
		if(input instanceof List) return performList.t(obj);
		if(input instanceof Set) return performSet.t(obj);
		
		throw new Exception("Invalid data type: "+input.getClass().getName());
	}
}
