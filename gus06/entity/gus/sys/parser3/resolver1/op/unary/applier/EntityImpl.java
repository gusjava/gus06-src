package gus06.entity.gus.sys.parser3.resolver1.op.unary.applier;

import gus06.framework.*;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151112";}


	private Service prepare;

	public EntityImpl() throws Exception
	{
		prepare = Outside.service(this,"gus.sys.parser3.prepare");
	}

	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		Map tag = (Map) o[0];
		T t = (T) o[1];
		
		Object value = t.t(tag);
		if(value==null) throw new Exception("Invalid value type for operator: null");

		if(value instanceof String)
		return build((String) value,t);
		
		throw new Exception("Invalid value type for operator: "+value.getClass().getName());
	}
	
	
	private Object build(String value, T t) throws Exception
	{
		List list = (List) prepare.t(value);
		return new G1(list,t);
	}
	
	
	private class G1 implements G
	{
		private List list;
		private T t;
		
		public G1(List list, T t)
		{
			this.list = list;
			this.t = t;
		}
		
		public Object g() throws Exception
		{return t.t(list);}
	}
}
