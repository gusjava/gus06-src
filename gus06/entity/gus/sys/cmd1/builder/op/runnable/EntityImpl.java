package gus06.entity.gus.sys.cmd1.builder.op.runnable;

import gus06.framework.*;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20150626";}
	
	
	public void p(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=1) throw new Exception("Wrong data number: "+o.length);
		
		Runnable r = (Runnable) o[0];
		
		r.run();
	}
}
