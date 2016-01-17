package gus06.entity.gus.sys.expression1.findvalue.map;

import gus06.framework.*;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.io.File;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150905";}

	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		Map map = (Map) o[0];
		String key = (String) o[1];
		
		if(key.equals("true")) return Boolean.TRUE;
		if(key.equals("false")) return Boolean.FALSE;
		if(key.equals("null")) return null;
		
		if(!map.containsKey(key)) return null;
		return map.get(key);
	}
}
