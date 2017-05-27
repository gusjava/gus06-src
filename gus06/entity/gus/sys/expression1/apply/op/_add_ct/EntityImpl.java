package gus06.entity.gus.sys.expression1.apply.op._add_ct;

import gus06.framework.*;
import java.util.Set;
import java.util.List;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160712";}



	private Service perform;
	
	
	public EntityImpl() throws Exception
	{
		perform = Outside.service(this,"gus.data.perform.add.strict");
	}

	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		Object value = o[0];
		
		if(value==null) return null;
		
		if(value instanceof Set) return new T1(value);
		if(value instanceof List) return new T1(value);
		
		throw new Exception("Invalid data type: "+value.getClass().getName());
	}
	
	
	private class T1 implements T
	{
		private Object value;
		public T1(Object value)
		{this.value = value;}
		
		public Object t(Object obj) throws Exception
		{return perform.t(new Object[]{value,obj});}
	}
}
