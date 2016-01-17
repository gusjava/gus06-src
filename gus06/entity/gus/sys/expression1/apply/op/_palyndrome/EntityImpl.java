package gus06.entity.gus.sys.expression1.apply.op._palyndrome;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151124";}
	
	
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return Boolean.FALSE;
		if(!(obj instanceof String)) return Boolean.FALSE;
		
		return new Boolean(isPalyndrome((String) obj));
	}
	
	
	private boolean isPalyndrome(String s)
	{
		StringBuffer b = new StringBuffer(s);
		return b.reverse().toString().equals(s);
	}
}