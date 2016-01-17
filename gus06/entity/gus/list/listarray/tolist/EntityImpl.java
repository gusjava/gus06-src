package gus06.entity.gus.list.listarray.tolist;

import gus06.framework.*;
import java.util.List;
import java.util.ArrayList;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151030";}


	public Object t(Object obj) throws Exception
	{
		List[] ll = (List[]) obj;
		List list = new ArrayList();
		for(List l:ll) list.addAll(l);
		return list;
	}
}
