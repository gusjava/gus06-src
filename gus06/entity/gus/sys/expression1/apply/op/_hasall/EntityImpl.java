package gus06.entity.gus.sys.expression1.apply.op._hasall;

import gus06.framework.*;
import java.util.Map;
import java.util.List;
import java.util.Set;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160201";}


	private Service colContainsAll;
	private Service mapContainsKeyAll;
	private Service arrayContainsAll;
	
	
	public EntityImpl() throws Exception
	{
		colContainsAll = Outside.service(this,"gus.collection.containsall.coltof");
		mapContainsKeyAll = Outside.service(this,"gus.map.containsall.key.maptof");
		arrayContainsAll = Outside.service(this,"gus.array.containsall.arraytof");
	}

	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		Object value = o[0];
		Map opMap = (Map) o[1];
		
		if(value==null) return null;
		
		if(value instanceof List) return colContainsAll.t(value);
		if(value instanceof Set) return colContainsAll.t(value);
		if(value instanceof Map) return mapContainsKeyAll.t(value);
		if(value instanceof Object[]) return arrayContainsAll.t(value);
		
		throw new Exception("Invalid data type: "+value.getClass().getName());
	}
	
}
