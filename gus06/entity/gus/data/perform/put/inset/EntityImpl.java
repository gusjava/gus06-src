package gus06.entity.gus.data.perform.put.inset;

import gus06.framework.*;
import java.util.List;
import java.util.Map;

public class EntityImpl implements Entity, P, T {

	public String creationDate() {return "20160613";}
	
	
	private Service performMap;
	
	public EntityImpl() throws Exception
	{
		performMap = Outside.service(this,"gus.map.put.inset");
	}

	
	public void p(Object obj) throws Exception
	{
		performMap.p(toArray(obj));
	}
	
	public Object t(Object obj) throws Exception
	{
		return performMap.t(toArray(obj));
	}
	
	
	
	private Object[] toArray(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		Object input = o[0];
		Object data = o[1];
		
		if(!(input instanceof Map))
			throw new Exception("Invalid data type: "+input.getClass().getName());
		
		if(data instanceof Object[])
		{
			Object[] tt = (Object[]) data;
			if(tt.length!=2) throw new Exception("Wrong data number: "+tt.length);
			return new Object[]{input,tt[0],tt[1]};
		}
		if(data instanceof List)
		{
			List l = (List) data;
			if(l.size()!=2) throw new Exception("Wrong data number: "+l.size());
			return new Object[]{input,l.get(0),l.get(1)};
		}
			
		throw new Exception("Invalid data type: "+data.getClass().getName());
	}
}
