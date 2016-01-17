package gus06.entity.gus.sys.parser3.resolver1.op.binary.inf1.cut;

import gus06.framework.*;
import java.util.List;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151029";}


	private Service cutMethod;
	
	public EntityImpl() throws Exception
	{
		cutMethod = Outside.service(this,"gus.sys.parser3.resolver1.cut.d.symbol2");
	}

	
	public Object t(Object obj) throws Exception
	{
		List l = (List) obj;
		Object cut = cutMethod.t(new Object[]{l,"<","="});
		if(cut!=null) return cut;
		return cutMethod.t(new Object[]{l,"=","<"});
	}
}
