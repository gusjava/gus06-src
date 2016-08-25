package gus06.entity.gus.find.integer;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150529";}


	private Service stringToInteger;
	private Service booleanToInteger;


	public EntityImpl() throws Exception
	{
		stringToInteger = Outside.service(this,"gus.convert.stringtointeger");
		booleanToInteger = Outside.service(this,"gus.convert.booleantointeger");
	}

	
	
	public Object t(Object obj) throws Exception
	{
		if(obj instanceof Integer) return obj;
		if(obj instanceof String) return stringToInteger.t(obj);
		if(obj instanceof Boolean) return booleanToInteger.t(obj);
		
		if(obj instanceof Long) return new Integer(((Long)obj).intValue());
		if(obj instanceof Double) return new Integer(((Double)obj).intValue());
		if(obj instanceof Float) return new Integer(((Float)obj).intValue());
		if(obj instanceof Short) return new Integer(((Short)obj).intValue());
		if(obj instanceof Byte) return new Integer(((Byte)obj).intValue());
		
		throw new Exception("Invalid type: "+obj.getClass().getName());
	}
	
	
	
}
