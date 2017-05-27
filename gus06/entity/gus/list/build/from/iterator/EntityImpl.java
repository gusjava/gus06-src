package gus06.entity.gus.list.build.from.iterator;

import gus06.framework.*;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20170225";}

	
	
	public Object t(Object obj) throws Exception
	{
		Iterator it = (Iterator) obj;
		List list = new ArrayList();
		while(it.hasNext()) list.add(it.next());
		return list;
	}
}
