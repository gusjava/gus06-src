package gus06.entity.gus.sys.opposite1.set.abs;

import gus06.framework.*;
import java.util.List;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160721";}


	private Service check;
	private Service perform;
	
	public EntityImpl() throws Exception
	{
		check = Outside.service(this,"gus.sys.opposite1.check");
		perform = Outside.service(this,"gus.sys.opposite1.set.perform");
	}


	public Object t(Object obj) throws Exception
	{
		if(check.f(obj)) return perform.t(obj);
		return obj;
	}
}
