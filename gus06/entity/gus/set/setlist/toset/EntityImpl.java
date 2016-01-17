package gus06.entity.gus.set.setlist.toset;

import gus06.framework.*;
import java.util.Set;
import java.util.HashSet;
import java.util.List;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151119";}


	public Object t(Object obj) throws Exception
	{
		List ll = (List) obj;
		Set set = new HashSet();
		for(Object l:ll) set.addAll((Set) l);
		return set;
	}
}
