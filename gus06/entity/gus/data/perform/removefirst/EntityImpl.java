package gus06.entity.gus.data.perform.removefirst;

import gus06.framework.*;
import java.util.List;

public class EntityImpl implements Entity, F, P {

	public String creationDate() {return "20160122";}

	
	public void p(Object obj) throws Exception
	{f(obj);}
	
	
	public boolean f(Object obj) throws Exception
	{
		if(obj instanceof List)
		{
			List l = (List) obj;
			if(l.isEmpty()) return false;
			l.remove(0);
			return true;
		}
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
}
