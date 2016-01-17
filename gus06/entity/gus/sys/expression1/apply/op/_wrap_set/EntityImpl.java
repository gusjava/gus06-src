package gus06.entity.gus.sys.expression1.apply.op._wrap_set;

import gus06.framework.*;
import java.util.HashSet;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151122";}


	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) throw new Exception("Enable to wrap null inside Set");
		
		HashSet set = new HashSet();
		set.add(obj);
		return set;
	}
}
