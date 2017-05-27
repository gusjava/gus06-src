package gus06.entity.gus.sys.expression1.apply.op._zero;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151110";}
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return null;
		
		if(obj instanceof Integer) return new Boolean(zero((Integer) obj));
		if(obj instanceof Double) return new Boolean(zero((Double) obj));
		if(obj instanceof Float) return new Boolean(zero((Float) obj));
		if(obj instanceof Long) return new Boolean(zero((Long) obj));
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	
	
	private boolean zero(Integer n)
	{return n.intValue()==0;}
	
	private boolean zero(Long n)
	{return n.longValue()==0;}
	
	private boolean zero(Double n)
	{return n.doubleValue()==0;}
	
	private boolean zero(Float n)
	{return n.floatValue()==0;}
}
