package gus06.entity.gus.data.perform.add0.y;

import gus06.framework.*;
import java.util.List;

public class EntityImpl implements Entity, P, T {

	public String creationDate() {return "20160816";}
	
	
	private Service performList;
	
	public EntityImpl() throws Exception
	{
		performList = Outside.service(this,"gus.list.add0.y");
	}

	
	public void p(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		Object input = o[0];
		
		if(input instanceof List)
		{performList.p(o);return;}
		
		if(input instanceof StringBuffer)
		{performSb(o);return;}
		
		throw new Exception("Invalid data type: "+input.getClass().getName());
	}
	
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		Object input = o[0];
		
		if(input instanceof List)
			return performList.t(obj);
		
		if(input instanceof String)
		{
			String s = (String) o[1];
			return ((String) input).startsWith(s) ? input : s+input;
		}
		
		throw new Exception("Invalid data type: "+input.getClass().getName());
	}
	
	
	
	
	private void performSb(Object[] o)
	{
		StringBuffer sb = (StringBuffer) o[0];
		String s = (String) o[1];
		
		if(!sb.toString().startsWith(s))
		sb.insert(0,s);
	}
}
