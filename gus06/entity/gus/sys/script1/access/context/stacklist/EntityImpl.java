package gus06.entity.gus.sys.script1.access.context.stacklist;

import gus06.framework.*;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151104";}
	
	
	
	public Object t(Object obj) throws Exception
	{
		Map context = (Map) obj;
		List stacks = new ArrayList();
		stacks.add(context);
		
		int n = 1;
		while(context.containsKey("stack_"+n))
		{
			Map stack = (Map) context.get("stack_"+n);
			stacks.add(stack);
			n++;
		}
		return stacks;
	}
}
