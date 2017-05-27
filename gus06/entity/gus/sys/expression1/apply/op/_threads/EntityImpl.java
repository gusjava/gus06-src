package gus06.entity.gus.sys.expression1.apply.op._threads;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20170504";}


	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		int count = Thread.activeCount();
 		Thread[] threads = new Thread[count];
		Thread.enumerate(threads);
		return threads;
	}
}
