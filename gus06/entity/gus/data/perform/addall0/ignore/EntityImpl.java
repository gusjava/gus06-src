package gus06.entity.gus.data.perform.addall0.ignore;

import gus06.framework.*;
import java.util.List;

public class EntityImpl implements Entity, P, T {

	public String creationDate() {return "20161207";}
	
	
	private Service performList;
	
	public EntityImpl() throws Exception
	{
		performList = Outside.service(this,"gus.list.addall0.ignore");
	}

	
	public void p(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		Object input = o[0];
		
		if(input instanceof List)
		{performList.p(obj);return;}
		
		throw new Exception("Invalid data type: "+input.getClass().getName());
	}
	
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		Object input = o[0];
		
		if(input instanceof List)
			return performList.t(obj);
		
		throw new Exception("Invalid data type: "+input.getClass().getName());
	}
}
