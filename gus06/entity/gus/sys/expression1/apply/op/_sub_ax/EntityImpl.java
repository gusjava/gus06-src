package gus06.entity.gus.sys.expression1.apply.op._sub_ax;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20170204";}


	private Service perform;


	public EntityImpl() throws Exception
	{
		perform = Outside.service(this,"gus.data.perform.substr.after.position");
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
			String cut = (String) obj;
			return new T2(data,cut);
		}
	}
	
	
	private class T2 implements T
	{
		private Object data;
		private String cut;
		
		public T2(Object data, String cut)
		{
			this.data = data;
			this.cut = cut;
		}
		
		public Object t(Object obj) throws Exception
		{
			return perform.t(new Object[]{data,cut,obj});
		}
	}
	
}
