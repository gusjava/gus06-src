package gus06.entity.gus.sys.expression1.apply.op._e_println;

import gus06.framework.*;
import java.io.PrintStream;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151204";}

	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		Object value = o[0];
		
		if(value==null) return null;
		if(value instanceof PrintStream) return new T1((PrintStream) value);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	
	private class T1 implements T
	{
		private PrintStream p;
		public T1(PrintStream p) {this.p = p;}
		
		public Object t(Object obj) throws Exception
		{return new E1(p,(String) obj);}
	}
	
	
	private class E1 implements E
	{
		private PrintStream p;
		private String s;
		
		public E1(PrintStream p, String s)
		{
			this.p = p;
			this.s = s;
		}
		public void e() throws Exception
		{p.println(s);}
	}
}
