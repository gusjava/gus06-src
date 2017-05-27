package gus06.entity.gus.sys.expression1.apply.op._many;

import gus06.framework.*;
import java.util.List;
import java.util.Set;
import java.util.Map;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151110";}


	private Service buildFilter;
	
	public EntityImpl() throws Exception
	{
		buildFilter = Outside.service(this,"gus.filter.array.build.many");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return null;
		
		if(obj instanceof Integer) 	return many((Integer) obj);
		if(obj instanceof Long) 	return many((Long) obj);
		
		if(obj instanceof List) 	return many((List) obj);
		if(obj instanceof Set) 		return many((Set) obj);
		if(obj instanceof Map) 		return many((Map) obj);
		
		if(obj instanceof boolean[])	return many((boolean[]) obj);
		if(obj instanceof F[])		return buildFilter.t(obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	
	
	
	private Boolean many(Integer n)
	{
		return new Boolean(n.intValue()>1);
	}
	private Boolean many(Long n)
	{
		return new Boolean(n.intValue()>1);
	}
	private Boolean many(List l)
	{
		return new Boolean(l.size()>1);
	}
	private Boolean many(Set l)
	{
		return new Boolean(l.size()>1);
	}
	private Boolean many(Map l)
	{
		return new Boolean(l.size()>1);
	}
	
	
	
	private Boolean many(boolean[] array)
	{
		int found = 0;
		for(boolean n:array) if(n)
		{
			found++;
			if(found>1) return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}
}
