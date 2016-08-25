package gus06.entity.gus.sys.expression1.apply.op._e_removelast;

import gus06.framework.*;
import java.util.List;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160122";}


	private Service perform;
	
	
	public EntityImpl() throws Exception
	{
		perform = Outside.service(this,"gus.data.perform.removelast");
	}

	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		Object value = o[0];
		
		if(value==null) return null;
		if(value instanceof List) return new E1(value);
		
		throw new Exception("Invalid data type: "+value.getClass().getName());
	}
	
	
	
	private class E1 implements E
	{
		private Object value;
		public E1(Object value){this.value = value;}
		
		public void e() throws Exception
		{perform.p(value);}
	}
}
