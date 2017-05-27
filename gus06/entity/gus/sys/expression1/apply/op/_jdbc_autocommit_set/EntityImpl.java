package gus06.entity.gus.sys.expression1.apply.op._jdbc_autocommit_set;

import gus06.framework.*;
import java.sql.Connection;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20170516";}


	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return null;
		if(obj instanceof Connection) return new T1((Connection) obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	
	private class T1 implements T
	{
		private Connection cx;
		public T1(Connection cx) {this.cx = cx;}
		
		public Object t(Object obj) throws Exception
		{
			Boolean value = (Boolean) obj;
			return new E1(cx,value);
		}
	}
	
	private class E1 implements E
	{
		private Connection cx;
		private Boolean value;
		
		public E1(Connection cx, Boolean value)
		{
			this.cx = cx;
			this.value = value;
		}
		
		public void e() throws Exception
		{cx.setAutoCommit(value);}
	}
}
