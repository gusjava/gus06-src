package gus06.entity.gus.set.setarray.eachdistinct;

import gus06.framework.*;
import java.util.Set;
import java.util.HashSet;

public class EntityImpl implements Entity, F {

	public String creationDate() {return "20160712";}


	public boolean f(Object obj) throws Exception
	{
		Set[] ss = (Set[]) obj;
		
		Set set = new HashSet();
		int n = 0;
		for(Set s:ss)
		{
			n += s.size();
			set.addAll(s);
		}
		return set.size() == n;
	}
}
