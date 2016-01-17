package gus06.manager.gus.gyem.m059.t.service.wrapper;

import gus06.manager.gus.gyem.GyemSystem;
import gus06.framework.*;

public class Module extends GyemSystem implements T {

	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		Object target = o[0];
		Object source = o[1];
		
		if(target==null) return ((G) module(M060_G_SERVICE_WRAPPER_EMPTY)).g();
		return ((T) module(M061_T_SERVICE_WRAPPER1)).t(obj);
	}
}