package gus06.entity.gus.sys.expression1.apply.op._rem_c01;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160325";}
	
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return null;
		if(obj instanceof String) return rem_c01((String) obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	
	
	private String rem_c01(String s) throws Exception
	{
		if(s.length()<3) return "";
		return s.substring(1,s.length()-1);
	}
}
