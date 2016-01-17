package gus06.entity.gus.list.op.sort;

import gus06.framework.*;
import java.util.List;
import java.util.Collections;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20150722";}


	public void p(Object obj) throws Exception
	{
		List l = (List) obj;
		Collections.sort(l);
	}
}
