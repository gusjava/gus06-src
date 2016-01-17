package gus06.entity.gus.map.removeat;

import gus06.framework.*;
import java.util.Map;

public class EntityImpl implements Entity, P, T {

	public String creationDate() {return "20151205";}
	
	
	public void p(Object obj) throws Exception
	{t(obj);}
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		Map map = (Map) o[0];
		Object key = o[1];
		
		return map.remove(key);
	}
}
