package gus06.entity.gus.sys.expression1.apply.op._e_sub0;

import gus06.framework.*;
import java.util.List;
import java.io.File;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160412";}


	private Service perform;


	public EntityImpl() throws Exception
	{
		perform = Outside.service(this,"gus.data.perform.subsequence0");
	}

	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return null;
		
		if(obj instanceof StringBuffer) return new T1(obj);
		if(obj instanceof List) return new T1(obj);
		if(obj instanceof File) return new T1(obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	
	private class T1 implements T
	{
		private Object data;
		public T1(Object data) {this.data = data;}
		
		public Object t(Object obj) throws Exception
		{
			String s = (String) obj;
			return new E1(data,s);
		}
	}
	
	private class E1 implements E
	{
		private Object data;
		private String rule;
		
		public E1(Object data, String rule)
		{
			this.data = data;
			this.rule = rule;
		}
		
		public void e() throws Exception
		{
			perform.p(new Object[]{data,rule});
		}
	}
}
