package gus06.entity.gus.sys.expression1.apply.op._split2_f;

import gus06.framework.*;
import java.util.List;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160611";}


	private Service perform;


	public EntityImpl() throws Exception
	{
		perform = Outside.service(this,"gus.data.perform.split2.first");
	}

	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return null;
		
		if(obj instanceof String) return new T1(obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	
	private class T1 implements T
	{
		private Object data;
		public T1(Object data) {this.data = data;}
		
		public Object t(Object obj) throws Exception
		{
			String s = (String) obj;
			return perform.t(new Object[]{data,s});
		}
	}
}
