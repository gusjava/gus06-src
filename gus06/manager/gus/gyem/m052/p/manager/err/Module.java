package gus06.manager.gus.gyem.m052.p.manager.err;

import java.util.Date;
import java.util.List;

import gus06.framework.Entity;
import gus06.framework.G;
import gus06.framework.P;
import gus06.manager.gus.gyem.GyemSystem;

public class Module extends GyemSystem implements P {

	
	public void p(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=3) throw new Exception("Wrong data number: "+o.length);
		
		Entity entity = (Entity) o[0];
		String id = (String) o[1];
		Exception exp = (Exception) o[2];
		Date date = new Date();
		
		List list = (List) ((G) module(M099_G_ERR_LIST)).g();
		list.add(new Object[]{entity,id,exp,date});
	}
}