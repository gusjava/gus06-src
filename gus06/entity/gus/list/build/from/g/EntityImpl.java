package gus06.entity.gus.list.build.from.g;

import gus06.framework.*;
import java.util.List;
import java.util.ArrayList;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20170225";}

	
	
	public Object t(Object obj) throws Exception
	{
		G g = (G) obj;
		List list = new ArrayList();
		Object value = g.g();
		while(value!=null)
		{
			list.add(value);
			value = g.g();
		}
		return list;
	}
}
