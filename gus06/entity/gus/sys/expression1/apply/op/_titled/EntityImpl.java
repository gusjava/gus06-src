package gus06.entity.gus.sys.expression1.apply.op._titled;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151114";}


	private Service titled;
	
	public EntityImpl() throws Exception
	{titled = Outside.service(this,"gus.string.transform.str.titled");}

	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return null;
		
		if(obj instanceof String) return titled.t(obj);
		if(obj instanceof String[]) return array((String[]) obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	
	
	private String[] array(String[] a) throws Exception
	{
		String[] a1 = new String[a.length];
		for(int i=0;i<a1.length;i++) a1[i] = (String) titled.t(a[i]);
		return a1;
	}
}
