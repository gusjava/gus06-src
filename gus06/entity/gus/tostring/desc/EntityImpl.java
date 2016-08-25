package gus06.entity.gus.tostring.desc;

import gus06.framework.*;
import java.util.List;
import java.util.Set;
import java.util.Map;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151125";}


	private Service listToString;
	private Service setToString;
	private Service mapToString;
	private Service arrayToString;
	private Service array2ToString;
	private Service short1;


	public EntityImpl() throws Exception
	{
		listToString = Outside.service(this,"gus.tostring.desc.list");
		setToString = Outside.service(this,"gus.tostring.desc.set");
		mapToString = Outside.service(this,"gus.tostring.desc.map");
		arrayToString = Outside.service(this,"gus.tostring.desc.array");
		array2ToString = Outside.service(this,"gus.tostring.desc.array2");
		short1 = Outside.service(this,"gus.tostring.desc.short1");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		if(obj==null) return "null";
		
		if(obj instanceof List) return listToString.t(obj);
		if(obj instanceof Set) return setToString.t(obj);
		if(obj instanceof Map) return mapToString.t(obj);
		if(obj instanceof Object[]) return arrayToString.t(obj);
		
		if(obj instanceof double[]) return array2ToString.t(obj);
		if(obj instanceof float[]) return array2ToString.t(obj);
		if(obj instanceof int[]) return array2ToString.t(obj);
		if(obj instanceof long[]) return array2ToString.t(obj);
		if(obj instanceof boolean[]) return array2ToString.t(obj);
		if(obj instanceof char[]) return array2ToString.t(obj);
		if(obj instanceof short[]) return array2ToString.t(obj);
		if(obj instanceof byte[]) return array2ToString.t(obj);
		
		return short1.t(obj);
	}
}
