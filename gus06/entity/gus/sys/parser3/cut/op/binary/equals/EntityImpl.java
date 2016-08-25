package gus06.entity.gus.sys.parser3.cut.op.binary.equals;

import gus06.framework.*;
import java.util.List;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151029";}


	private Service cutMethod;
	
	public EntityImpl() throws Exception
	{
		cutMethod = Outside.service(this,"gus.sys.parser3.cut.symbol.b2");
	}

	
	public Object t(Object obj) throws Exception
	{
		List l = (List) obj;
		return cutMethod.t(new Object[]{l,"=","="});
	}
}