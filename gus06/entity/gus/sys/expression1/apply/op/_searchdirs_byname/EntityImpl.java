package gus06.entity.gus.sys.expression1.apply.op._searchdirs_byname;

import gus06.framework.*;
import java.io.File;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151205";}


	private Service perform;
	
	
	public EntityImpl() throws Exception
	{
		perform = Outside.service(this,"gus.dir.perform.searchdirs.byname");
	}

	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		Object value = o[0];
		
		if(value==null) return null;
		if(value instanceof File) return new T1(value);
		
		throw new Exception("Invalid data type: "+value.getClass().getName());
	}
	
	
	private class T1 implements T
	{
		private Object value;
		public T1(Object value)
		{this.value = value;}
		
		public Object t(Object obj) throws Exception
		{
			String s = (String) obj;
			return perform.t(new Object[]{value,s});
		}
	}
}
