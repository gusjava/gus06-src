package gus06.entity.gus.sys.expression1.apply.op._setvalues;

import gus06.framework.*;
import java.util.Map;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160907";}


	private Service perform;
	
	
	public EntityImpl() throws Exception
	{
		perform = Outside.service(this,"gus.reflection.setter.setvalues");
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
		{return new E1(data,(Map)obj);}
	}
	
	
	
	private class E1 implements E
	{
		private Object data;
		private Map map;
		
		public E1(Object data, Map map)
		{
			this.data = data;
			this.map = map;
		}
		
		public void e() throws Exception
		{perform.p(new Object[]{data,map});}
	}
}
