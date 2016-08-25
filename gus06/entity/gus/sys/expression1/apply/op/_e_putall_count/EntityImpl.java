package gus06.entity.gus.sys.expression1.apply.op._e_putall_count;

import gus06.framework.*;
import java.util.Map;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160821";}


	private Service perform;
	
	public EntityImpl() throws Exception
	{
		perform = Outside.service(this,"gus.map.freqmap.appendall");
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
		private Object data;
		
		public T1(Object data)
		{this.data = data;}
		
		public Object t(Object obj) throws Exception
		{return new E1(data,obj);}
	}
	
	
	private class E1 implements E
	{
		private Object data;
		private Object col;
		
		public E1(Object data, Object col)
		{
			this.data = data;
			this.col = col;
		}
		
		public void e() throws Exception
		{perform.p(new Object[]{data,col});}
	}
}
