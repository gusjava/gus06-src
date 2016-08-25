package gus06.entity.gus.sys.expression1.apply.op._all;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151110";}
	
	
	private Service buildFilter;
	
	public EntityImpl() throws Exception
	{
		buildFilter = Outside.service(this,"gus.filter.array.build.all");
	}

	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return null;
		
		if(obj instanceof boolean[])	return all((boolean[]) obj);
		if(obj instanceof F[])		return buildFilter.t(obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	private Boolean all(boolean[] array)
	{
		for(boolean n:array) if(!n) return Boolean.FALSE;
		return Boolean.TRUE;
	}
}
