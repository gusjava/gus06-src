package gus06.entity.gus.sys.expression1.apply.op._replace1_i;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160413";}



	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return null;
		if(obj instanceof String) return new T1((String) obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	
	private class T1 implements T
	{
		private String line;
		
		public T1(String line)
		{this.line = line;}
		
		public Object t(Object obj) throws Exception
		{return new T2(line,toString_(obj));}
	}
	
	
	private class T2 implements T
	{
		private String line;
		private String s1;
		
		public T2(String line, String s1)
		{
			this.line = line;
			this.s1 = s1;
		}
		
		public Object t(Object obj) throws Exception
		{return replace(line,s1,toString_(obj));}
	}
	
	
	
	
	private String toString_(Object obj) throws Exception
	{
		if(obj instanceof Boolean) return ""+obj;
		if(obj instanceof Number) return ""+obj;
		if(obj instanceof String) return ""+obj;
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	
	private String replace(String line, String s1, String s2)
	{return line.replaceAll("(?i)"+s1,s2);}
}
