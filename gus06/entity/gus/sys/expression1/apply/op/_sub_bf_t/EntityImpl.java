package gus06.entity.gus.sys.expression1.apply.op._sub_bf_t;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160808";}
	
	public final static String DELIM = "\t";


	private Service perform;


	public EntityImpl() throws Exception
	{
		perform = Outside.service(this,"gus.data.perform.substr.before.first");
	}

	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return null;
		
		if(obj instanceof String) return perform.t(new Object[]{obj,DELIM});
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
}
