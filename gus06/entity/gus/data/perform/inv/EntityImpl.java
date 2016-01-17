package gus06.entity.gus.data.perform.inv;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151117";}


	private Service invFilter;
	private Service invFunction;
	
	public EntityImpl() throws Exception
	{
		invFilter = Outside.service(this,"gus.feature.op.filter.inv");
		invFunction = Outside.service(this,"gus.feature.op.function.inv");
	}

	
	
	public Object t(Object obj) throws Exception
	{
		if(obj instanceof Boolean) return inv((Boolean) obj);
		if(obj instanceof F) return inv((F) obj);
		if(obj instanceof H) return inv((H) obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	
	private Boolean inv(Boolean b)
	{return new Boolean(!b.booleanValue());}
	
	private F inv(F f) throws Exception
	{return (F) invFilter.t(f);}
	
	private H inv(H h) throws Exception
	{return (H) invFunction.t(h);}
}
