package gus06.entity.gus.data.perform.hasall;

import gus06.framework.*;
import java.util.Map;
import java.util.List;
import java.util.Set;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160905";}


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
		if(obj==null) return new F0();
		
		if(obj instanceof List) return colContainsAll.t(obj);
		if(obj instanceof Set) return colContainsAll.t(obj);
		if(obj instanceof Map) return mapContainsKeyAll.t(obj);
		if(obj instanceof Object[]) return arrayContainsAll.t(obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	private class F0 implements F
	{
		public boolean f(Object obj) throws Exception
		{return false;}
	}
}
