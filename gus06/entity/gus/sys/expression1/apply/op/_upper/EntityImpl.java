package gus06.entity.gus.sys.expression1.apply.op._upper;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151109";}
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return null;
		
		if(obj instanceof String[]) return array((String[]) obj);
		if(obj instanceof String) return ((String) obj).toUpperCase();
		
		if(obj instanceof Integer) return ""+obj;
		if(obj instanceof Double) return ""+obj;
		if(obj instanceof Float) return ""+obj;
		if(obj instanceof Long) return ""+obj;
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	
	
	private String[] array(String[] a)
	{
		String[] a1 = new String[a.length];
		for(int i=0;i<a1.length;i++) a1[i] = a[i].toUpperCase();
		return a1;
	}
}
