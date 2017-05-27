package gus06.entity.gus.sys.expression1.apply.op._e_putall_instring;

import gus06.framework.*;
import java.util.Map;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20161205";}


	private Service perform;
	
	public EntityImpl() throws Exception
	{
		perform = Outside.service(this,"gus.data.perform.putall.instring");
	}

	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		Object value = o[0];
		
		if(value==null) return null;
		
		if(value instanceof Map) return new T1(value);
		
		throw new Exception("Invalid data type: "+value.getClass().getName());
	}
	
	
	private class T1 implements T
	{
		private Object value;
		public T1(Object value)
		{this.value = value;}
		
		public Object t(Object obj) throws Exception
		{return new E1(new Object[]{value,obj});}
	}
	
	
	private class E1 implements E
	{
		private Object o;
		public E1(Object o){this.o = o;}
		
		public void e() throws Exception
		{perform.p(o);}
	}
}
