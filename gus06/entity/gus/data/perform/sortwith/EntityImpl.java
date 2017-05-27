package gus06.entity.gus.data.perform.sortwith;

import gus06.framework.*;
import java.util.List;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20170501";}
	
	
	private Service performList;
	
	public EntityImpl() throws Exception
	{
		performList = Outside.service(this,"gus.list.sortwith");
	}

	
	public void p(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		Object input = o[0];
		
		if(input instanceof List)
		{
			performList.p(obj);
			return;
		}
		
		throw new Exception("Invalid data type: "+input.getClass().getName());
	}
}
