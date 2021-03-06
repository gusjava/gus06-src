package gus06.entity.gus.sys.expression1.apply.op._hexa;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151110";}
	
	
	private Service byteToHexa;
	
	public EntityImpl() throws Exception
	{
		byteToHexa = Outside.service(this,"gus.tostring.bytetohexa");
	}

	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return null;
		if(obj instanceof Integer) return Integer.toHexString(toInt(obj)).toUpperCase();
		if(obj instanceof byte[]) return byteToHexa.t((byte[]) obj);
		if(obj instanceof String) return byteToHexa.t(((String) obj).getBytes("UTF8"));
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	private int toInt(Object obj)
	{return Integer.parseInt(""+obj);}
}
