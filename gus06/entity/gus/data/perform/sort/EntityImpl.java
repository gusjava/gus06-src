package gus06.entity.gus.data.perform.sort;

import gus06.framework.*;
import java.util.List;
import java.util.Collections;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20151114";}
	
	
	public void p(Object obj) throws Exception
	{
		if(obj instanceof List) {sort((List) obj);return;}
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	private void sort(List l)
	{Collections.sort(l);}
}
