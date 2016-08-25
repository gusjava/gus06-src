package gus06.entity.gus.map.deep.nextdata0;

import gus06.framework.*;
import java.util.Map;
import java.util.List;
import java.util.Set;
import java.util.Iterator;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160312";}


	private Service map;
	private Service list;
	private Service set;
	private Service r;
	private Service g;

	public EntityImpl() throws Exception
	{
		map = Outside.service(this,"gus.map.deep.nextdata0.map");
		list = Outside.service(this,"gus.map.deep.nextdata0.list");
		set = Outside.service(this,"gus.map.deep.nextdata0.set");
		r = Outside.service(this,"gus.map.deep.nextdata0.r");
		g = Outside.service(this,"gus.map.deep.nextdata0.g");
	}

	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2)	throw new Exception("Wrong data number: "+o.length);
		
		Object data = o[0];
		String key = (String) o[1];
		
		if(data==null) return null;
		
		if(data instanceof Map) return map.t(obj);
		if(data instanceof List) return list.t(obj);
		if(data instanceof Set) return set.t(obj);
		if(data instanceof R) return r.t(obj);
		if(data instanceof G) return g.t(obj);
		
		throw new Exception("Invalid data type: "+data.getClass().getName());
	}
}
