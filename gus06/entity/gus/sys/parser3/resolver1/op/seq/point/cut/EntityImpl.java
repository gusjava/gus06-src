package gus06.entity.gus.sys.parser3.resolver1.op.seq.point.cut;

import gus06.framework.*;
import java.util.List;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151031";}


	private Service cutMethod;
	
	public EntityImpl() throws Exception
	{
		cutMethod = Outside.service(this,"gus.sys.parser3.resolver1.cut.symbol1");
	}

	
	public Object t(Object obj) throws Exception
	{
		List l = (List) obj;
		return cutMethod.t(new Object[]{l,"."});
	}
}
