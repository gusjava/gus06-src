package gus06.entity.gus.sys.expression1.apply.op._any;

import gus06.framework.*;
import java.util.Collection;
import java.util.Map;
import java.util.Iterator;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160805";}


	private Service buildFilter;
	
	public EntityImpl() throws Exception
	{
		buildFilter = Outside.service(this,"gus.filter.array.build.any");
	}

	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return null;
		
		if(obj instanceof Integer)	return any((Integer) obj);
		if(obj instanceof boolean[])	return any((boolean[]) obj);
		if(obj instanceof F[])		return buildFilter.t(obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	
	
	private Boolean any(Integer n)
	{
		return new Boolean(n.intValue()>0);
	}
	
	private Boolean any(boolean[] array)
	{
		for(boolean n:array) if(n) return Boolean.TRUE;
		return Boolean.FALSE;
	}
}
