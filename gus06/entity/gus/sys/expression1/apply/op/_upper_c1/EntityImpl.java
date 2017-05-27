package gus06.entity.gus.sys.expression1.apply.op._upper_c1;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160413";}

	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return null;
		
		if(obj instanceof String[]) return array((String[]) obj);
		if(obj instanceof String) return upperC1((String) obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	
	
	private String[] array(String[] a)
	{
		String[] a1 = new String[a.length];
		for(int i=0;i<a1.length;i++) a1[i] = upperC1(a[i]);
		return a1;
	}
	
	private String upperC1(String s)
	{
		if(s.equals("")) return s;
		int n = s.length();
		return s.substring(0,n-1) + s.substring(n-1).toUpperCase();
	}
}
