package gus06.entity.gus.sys.expression1.apply.op._toboolean;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151109";}
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return null;
		
		if(obj instanceof String) return new Boolean((String) obj);
		if(obj instanceof Integer) return toBool((Integer) obj);
		if(obj instanceof F) return new Boolean(((F) obj).f(null));
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	
	private Boolean toBool(Integer n)
	{
		int v = n.intValue();
		if(v==0) return Boolean.FALSE;
		if(v==1) return Boolean.TRUE;
		return null;
	}
}
