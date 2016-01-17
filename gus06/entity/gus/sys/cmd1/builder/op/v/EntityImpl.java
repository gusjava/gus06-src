package gus06.entity.gus.sys.cmd1.builder.op.v;

import gus06.framework.*;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20150626";}

	
	public void p(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=3) throw new Exception("Wrong data number: "+o.length);
		
		V v = (V) o[0];
		
		v.v((String) o[1],o[2]);
	}
}
