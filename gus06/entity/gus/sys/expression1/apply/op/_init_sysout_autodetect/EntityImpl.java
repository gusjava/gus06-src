package gus06.entity.gus.sys.expression1.apply.op._init_sysout_autodetect;

import gus06.framework.*;
import java.util.Map;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160315";}


	private Service init;
	
	public EntityImpl() throws Exception
	{
		init = Outside.service(this,"gus.debug.sysout.autodetectmode");
	}

	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		return init;
	}
}
