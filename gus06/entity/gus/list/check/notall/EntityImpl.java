package gus06.entity.gus.list.check.notall;

import gus06.framework.*;
import java.util.List;

public class EntityImpl implements Entity, F {

	public String creationDate() {return "20160804";}
	
	
	public boolean f(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		List input = (List) o[0];
		F filter = (F) o[1];
		
		int nb = input.size();
		for(int i=0;i<nb;i++)
		{
			Object element = input.get(i);
			if(!filter.f(element)) return true;
		}
		return false;
	}
}
