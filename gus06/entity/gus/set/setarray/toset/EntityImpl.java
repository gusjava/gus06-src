package gus06.entity.gus.set.setarray.toset;

import gus06.framework.*;
import java.util.Set;
import java.util.HashSet;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151030";}


	public Object t(Object obj) throws Exception
	{
		Set[] ss = (Set[]) obj;
		Set set = new HashSet();
		for(Set s:ss) set.addAll(s);
		return set;
	}
}
