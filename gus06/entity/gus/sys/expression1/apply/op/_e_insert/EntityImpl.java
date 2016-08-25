package gus06.entity.gus.sys.expression1.apply.op._e_insert;

import gus06.framework.*;
import java.util.List;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160131";}


	private Service perform;
	
	
	public EntityImpl() throws Exception
	{
		perform = Outside.service(this,"gus.data.perform.insert");
	}

	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		Object value = o[0];
		
		if(value==null) return null;
		
		if(value instanceof List) return new T1(value);
		
		throw new Exception("Invalid data type: "+value.getClass().getName());
	}
	
	
	private class T1 implements T
	{
		private Object value;
		public T1(Object value)
		{this.value = value;}
		
		public Object t(Object obj) throws Exception
		{return new T2(value,toInteger(obj));}
	}
	
	private class T2 implements T
	{
		private Object value;
		private Integer index;
		
		public T2(Object value, Integer index)
		{
			this.value = value;
			this.index = index;
		}
		
		public Object t(Object obj) throws Exception
		{return new E1(new Object[]{value,index,obj});}
	}
	
	
	private class E1 implements E
	{
		private Object o;
		public E1(Object o){this.o = o;}
		
		public void e() throws Exception
		{perform.p(o);}
	}
	
	
	private Integer toInteger(Object obj) throws Exception
	{
		if(obj instanceof Integer) return (Integer) obj;
		if(obj instanceof String) return new Integer((String) obj);
		throw new Exception("Invalid index type: " + obj.getClass().getName());
	}
}
