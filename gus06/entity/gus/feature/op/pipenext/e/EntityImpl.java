package gus06.entity.gus.feature.op.pipenext.e;

import gus06.framework.*;
import java.util.Map;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20161212";}


	private Service eg;
	private Service ee;
	private Service loop_e;
	
	public EntityImpl() throws Exception
	{
		eg = Outside.service(this,"gus.feature.wrap.eg.g");
		ee = Outside.service(this,"gus.feature.wrap.ee.e");
		loop_e = Outside.service(this,"gus.feature.op.loop.e");
	}


	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		E e = (E) o[0];
		
		if(o[1] instanceof G) return eg.t(o);
		if(o[1] instanceof E) return ee.t(o);
		if(o[1] instanceof Integer) return loop_e.t(o);
		
		throw new Exception("Invalid data type: "+o[1].getClass().getName());
	}
}
