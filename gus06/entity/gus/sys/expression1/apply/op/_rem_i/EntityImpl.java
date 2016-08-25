package gus06.entity.gus.sys.expression1.apply.op._rem_i;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160413";}
	
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return null;
		if(obj instanceof String) return new T2((String) obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	
	
	private class T2 implements T
	{
		private String value;
		public T2(String value) {this.value = value;}
		
		public Object t(Object obj) throws Exception
		{
			if(obj==null) return value;
			return rem(value,(String) obj);
		}
	}
	
	
	
	private Object rem(String s1, String s2) throws Exception
	{
		return s1.replaceAll("(?i)"+s2,"");
	}
	
}
