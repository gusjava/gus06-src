package gus06.entity.gus.sys.expression1.apply.op._gen_token1;

import gus06.framework.*;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Iterator;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160306";}


	private Service randomToken1;
	
	public EntityImpl() throws Exception
	{
		randomToken1 = Outside.service(this,"gus.data.generate.string.random.token1");
	}

	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		return randomToken1.g();
	}
}
