package gus06.entity.gus.sys.jsonparser1.evaluate;

import gus06.framework.*;
import java.util.List;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151125";}


	private Service prepare;
	private Service resolver;
	
	
	public EntityImpl() throws Exception
	{
		prepare = Outside.service(this,"gus.sys.parser3.prepare");
		resolver = Outside.service(this,"gus.sys.jsonparser1.resolver");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		List l = (List) prepare.t(obj);
		return resolver.t(l);
	}
}
