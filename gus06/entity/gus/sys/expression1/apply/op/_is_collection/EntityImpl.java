package gus06.entity.gus.sys.expression1.apply.op._is_collection;

import gus06.framework.*;
import java.util.Collection;

public class EntityImpl implements Entity, T, R {

	public String creationDate() {return "20151201";}
	
	
	public Object t(Object obj) throws Exception
	{
		if(obj==null) return Boolean.FALSE;
		return new Boolean(obj instanceof Collection);
	}
	
	public Object r(String key) throws Exception
	{
		if(key.equals("types")) return new Class[]{Object.class};
		if(key.equals("keys")) return new String[]{"types"};
		throw new Exception("Unknown key: "+key);
	}
}
