package gus06.entity.gus.sys.expression1.apply.op._setvalue;

import gus06.framework.*;
import java.util.Map;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160604";}


	private Service perform;
	
	
	public EntityImpl() throws Exception
	{
		perform = Outside.service(this,"gus.reflection.setter.setvalue");
	}

	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		Object value = o[0];
		
		if(value==null) return null;
		return new T1(value);
	}
	
	
	private class T1 implements T
	{
		private Object data;
		
		public T1(Object data)
		{this.data = data;}
		
		public Object t(Object obj) throws Exception
		{return new T2(data,(String)obj);}
	}
	
	private class T2 implements T
	{
		private Object data;
		private String name;
		
		public T2(Object data, String name)
		{
			this.data = data;
			this.name = name;
		}
		
		public Object t(Object obj) throws Exception
		{return new E1(data,name,obj);}
	}
	
	
	private class E1 implements E
	{
		private Object data;
		private Object name;
		private Object value;
		
		public E1(Object data, Object name, Object value)
		{
			this.data = data;
			this.name = name;
			this.value = value;
		}
		
		public void e() throws Exception
		{perform.p(new Object[]{data,name,value});}
	}
}
