package gus06.entity.gus.map.maparray.toset;

import gus06.framework.*;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151202";}


	public Object t(Object obj) throws Exception
	{
		Map[] mm = (Map[]) obj;
		Set set = new HashSet();
		for(Map m:mm) set.addAll(m.keySet());
		return set;
	}
}
