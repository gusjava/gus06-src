package gus06.entity.gus.sys.expression1.apply.op._has;

import gus06.framework.*;
import java.util.Map;
import java.util.List;
import java.util.Set;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160120";}


	private Service colContains;
	private Service mapContainsKey;
	private Service arrayContains;
	
	
	public EntityImpl() throws Exception
	{
		colContains = Outside.service(this,"gus.collection.contains.coltof");
		mapContainsKey = Outside.service(this,"gus.map.contains.key.maptof");
		arrayContains = Outside.service(this,"gus.array.contains.arraytof");
	}

	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		Object value = o[0];
		Map opMap = (Map) o[1];
		
		if(value==null) return null;
		
		if(value instanceof List) return colContains.t(value);
		if(value instanceof Set) return colContains.t(value);
		if(value instanceof Map) return mapContainsKey.t(value);
		if(value instanceof Object[]) return arrayContains.t(value);
		
		throw new Exception("Invalid data type: "+value.getClass().getName());
	}
	
}
