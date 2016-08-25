package gus06.entity.gus.sys.expression1.apply.op._distance_str1;

import gus06.framework.*;
import java.util.List;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160805";}


	private Service perform;

	public EntityImpl() throws Exception
	{
		perform = Outside.service(this,"gus.data.compare.string.comparator1.distance");
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
		private String s1;
		public T1(String s1) {this.s1 = s1;}
		
		public Object t(Object obj) throws Exception
		{
			String s2 = (String) obj;
			return perform.t(new String[]{s1,s2});
		}
	}
}
