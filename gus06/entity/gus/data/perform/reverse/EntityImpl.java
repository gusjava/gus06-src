package gus06.entity.gus.data.perform.reverse;

import gus06.framework.*;
import java.util.List;
import java.util.Collections;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20151114";}
	
	
	public void p(Object obj) throws Exception
	{
		if(obj instanceof StringBuffer)
		{reverse((StringBuffer) obj);return;}
		
		if(obj instanceof List)
		{reverse((List) obj);return;}
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	private void reverse(StringBuffer b)
	{b.reverse();}
	
	private void reverse(List l)
	{Collections.reverse(l);}
}
