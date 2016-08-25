package gus06.entity.gus.data.perform.addnew;

import gus06.framework.*;
import java.util.Set;

public class EntityImpl implements Entity, P, T {

	public String creationDate() {return "20160808";}
	
	
	private Service performSet;
	
	public EntityImpl() throws Exception
	{
		performSet = Outside.service(this,"gus.set.addnew");
	}

	
	public void p(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		Object input = o[0];
		
		if(input instanceof Set)
		{performSet.p(obj);return;}
		
		throw new Exception("Invalid data type: "+input.getClass().getName());
	}
	
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		Object input = o[0];
		
		if(input instanceof Set)
			return performSet.t(obj);
		
		throw new Exception("Invalid data type: "+input.getClass().getName());
	}
}
