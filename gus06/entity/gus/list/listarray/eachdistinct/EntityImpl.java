package gus06.entity.gus.list.listarray.eachdistinct;

import gus06.framework.*;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

public class EntityImpl implements Entity, F {

	public String creationDate() {return "20160712";}


	public boolean f(Object obj) throws Exception
	{
		List[] ll = (List[]) obj;
		
		Set set = new HashSet();
		int n = 0;
		for(List l:ll)
		{
			n += l.size();
			set.addAll(l);
		}
		return set.size() == n;
	}
}
