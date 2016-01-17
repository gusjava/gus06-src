package gus06.entity.gus.sys.expression1.apply.op._toset;

import gus06.framework.*;
import java.util.List;
import java.util.HashSet;
import java.sql.ResultSet;
import java.util.Map;
import java.util.Collection;
import java.util.Set;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151109";}


	private Service rsToSet;
	
	public EntityImpl() throws Exception
	{
		rsToSet = Outside.service(this,"gus.jdbc.resultset.tostringset");
	}

	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return null;
		
		if(obj instanceof Set) return obj;
		if(obj instanceof List) return new HashSet((List) obj);
		if(obj instanceof Collection) return new HashSet((Collection) obj);
		if(obj instanceof Map) return new HashSet(((Map) obj).values());
		if(obj instanceof ResultSet) return rsToSet.t((ResultSet) obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
}
