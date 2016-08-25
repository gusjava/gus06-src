package gus06.entity.gus.data.perform.addall;

import gus06.framework.*;
import java.util.List;
import java.util.Set;

public class EntityImpl implements Entity, P, T {

	public String creationDate() {return "20160128";}
	
	
	private Service performList;
	private Service performSet;
	
	public EntityImpl() throws Exception
	{
		performList = Outside.service(this,"gus.list.addall");
		performSet = Outside.service(this,"gus.set.addall");
	}

	
	public void p(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		Object input = o[0];
		
		if(input instanceof List)
		{performList.p(obj);return;}
		
		if(input instanceof Set)
		{performSet.p(obj);return;}
		
		throw new Exception("Invalid data type: "+input.getClass().getName());
	}
	
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		Object input = o[0];
		
		if(input instanceof List)
			return performList.t(obj);
		
		if(input instanceof Set)
			return performSet.t(obj);
		
		throw new Exception("Invalid data type: "+input.getClass().getName());
	}
}
