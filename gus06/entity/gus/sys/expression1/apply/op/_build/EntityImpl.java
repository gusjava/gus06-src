package gus06.entity.gus.sys.expression1.apply.op._build;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160612";}


	private Service play1;
	
	
	public EntityImpl() throws Exception
	{
		play1 = Outside.service(this,"gus.sys.play1.manager");
	}

	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return null;
		if(obj instanceof int[]) return build((String) obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	
	private Object build(String key) throws Exception
	{
		if(key.equals("play1")) return play1;
		
		throw new Exception("Unknown key: "+key);
	}
}
