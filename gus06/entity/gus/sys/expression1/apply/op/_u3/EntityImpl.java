package gus06.entity.gus.sys.expression1.apply.op._u3;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20170211";}

	public static final long FACTOR = 1000L;
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return null;
		
		if(obj instanceof Integer) return handleInt((Integer) obj);
		if(obj instanceof Long) return handleLong((Long) obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	
	private Object handleInt(Integer n)
	{
		long r = n.longValue()*FACTOR;
		if(r<=Integer.MAX_VALUE) return new Integer((int) r);
		return new Long(r);
	}
	
	private Object handleLong(Long n)
	{
		long r = n.longValue()*FACTOR;
		return new Long(r);
	}
}
