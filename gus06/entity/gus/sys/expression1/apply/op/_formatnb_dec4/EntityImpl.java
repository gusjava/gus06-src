package gus06.entity.gus.sys.expression1.apply.op._formatnb_dec4;

import gus06.framework.*;
public class EntityImpl implements Entity, T {

	public String creationDate() {return "20170112";}


	private Service perform;
	
	public EntityImpl() throws Exception
	{
		perform = Outside.service(this,"gus.string.transform.format.number.decimal4");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return null;
		
		if(obj instanceof String) return perform.t(obj);
		if(obj instanceof Double) return perform.t(obj);
		if(obj instanceof Float) return perform.t(obj);
		
		if(obj instanceof Object[]) return perform.t(obj);
		if(obj instanceof double[]) return perform.t(obj);
		if(obj instanceof float[]) return perform.t(obj);
		
		if(obj instanceof Object[][]) return perform.t(obj);
		if(obj instanceof double[][]) return perform.t(obj);
		if(obj instanceof float[][]) return perform.t(obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
}
