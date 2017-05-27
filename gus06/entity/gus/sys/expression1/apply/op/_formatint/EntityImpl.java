package gus06.entity.gus.sys.expression1.apply.op._formatint;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160407";}
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return null;
		if(obj instanceof Integer) return new T1(_int((Integer) obj));
		if(obj instanceof String) return new T1(_int((String) obj));
		
		return new Boolean(obj instanceof Integer);
	}
	
	
	
	private class T1 implements T
	{
		private int n;
		public T1(int n) {this.n = n;}
		
		public Object t(Object obj) throws Exception
		{
			String format = ""+obj;
			int l = _int(format);
			if(l==-1) l = format.length();
			
			String s = ""+n;
			while(s.length()<l) s = "0"+s;
			return s;
		}
	}
	
	private int _int(Integer n)
	{
		return n.intValue();
	}
	
	private int _int(String s)
	{
		try{return Integer.parseInt(s);}
		catch(NumberFormatException e)
		{return -1;}
	}
}