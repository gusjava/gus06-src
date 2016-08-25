package gus06.entity.gus.sys.expression1.apply.op._counter;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160420";}


	private Service perform;
	
	public EntityImpl() throws Exception
	{
		perform = Outside.service(this,"gus.app.persister1.counter");
	}

	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		obj = o[0];
		
		if(obj==null) return null;
		if(obj instanceof String) return toInt(perform.r(getClass().getName()+"_"+obj));
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	
	private Integer toInt(Object obj) throws Exception
	{
		if(obj instanceof Integer) return (Integer) obj;
		if(obj instanceof String) return new Integer((String) obj);
		
		throw new Exception("Invalid output data type: "+obj.getClass().getName());
	}
}
