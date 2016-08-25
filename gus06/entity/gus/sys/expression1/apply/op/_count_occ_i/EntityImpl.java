package gus06.entity.gus.sys.expression1.apply.op._count_occ_i;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160808";}


	private Service perform;

	
	public EntityImpl() throws Exception
	{
		perform = Outside.service(this,"gus.string.count.substrings_i");
	}

	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return null;
		
		if(obj instanceof String) return new T1((String) obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	
	
	
	private class T1 implements T
	{
		private String data;
		public T1(String data){this.data = data;}
		
		public Object t(Object obj) throws Exception
		{return perform.t(new String[]{data,(String) obj});}
	}
}
