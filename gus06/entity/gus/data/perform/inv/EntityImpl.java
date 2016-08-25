package gus06.entity.gus.data.perform.inv;

import gus06.framework.*;
import java.util.Map;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151117";}


	private Service invFilter;
	private Service invFunction;
	private Service invMap;
	
	public EntityImpl() throws Exception
	{
		invFilter = Outside.service(this,"gus.feature.op.filter.inv");
		invFunction = Outside.service(this,"gus.feature.op.function.inv");
		invMap = Outside.service(this,"gus.map.inv");
	}

	
	
	public Object t(Object obj) throws Exception
	{
		if(obj instanceof Boolean) return inv((Boolean) obj);
		if(obj instanceof Double) return inv((Double) obj);
		if(obj instanceof Integer) return inv((Integer) obj);
		if(obj instanceof Float) return inv((Float) obj);
		if(obj instanceof F) return inv((F) obj);
		if(obj instanceof H) return inv((H) obj);
		if(obj instanceof Map) return inv((Map) obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	
	private Boolean inv(Boolean b)
	{return new Boolean(!b.booleanValue());}
	
	private Double inv(Double b)
	{return new Double(1.0/b.doubleValue());}
	
	private Double inv(Integer b)
	{return new Double(1.0/b.doubleValue());}
	
	private Float inv(Float b)
	{return new Float(1.0/b.floatValue());}
	
	private F inv(F f) throws Exception
	{return (F) invFilter.t(f);}
	
	private H inv(H h) throws Exception
	{return (H) invFunction.t(h);}
	
	private Map inv(Map m) throws Exception
	{return (Map) invMap.t(m);}
}
