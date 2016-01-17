package gus06.entity.gus.sys.expression1.apply.op._findall_en;

import gus06.framework.*;
import java.util.List;
import java.util.Set;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151124";}


	private Service builder;
	private Service perform;
	
	
	public EntityImpl() throws Exception
	{
		builder = Outside.service(this,"gus.filter.string.build.endswith");
		perform = Outside.service(this,"gus.data.perform.findall");
	}

	
	public Object t(Object obj) throws Exception
	{
		if(obj==null) return null;
		
		if(obj instanceof List) return new T1(obj);
		if(obj instanceof Set) return new T1(obj);
		if(obj instanceof Object[]) return new T1(obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	
	private class T1 implements T
	{
		private Object data;
		public T1(Object data) {this.data = data;}
		
		public Object t(Object obj) throws Exception
		{
			F f = (F) builder.t(obj);
			return perform.t(new Object[]{data,f});
		}
	}
}
