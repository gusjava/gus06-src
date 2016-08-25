package gus06.entity.gus.sys.expression1.apply.op._binary;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151110";}


	private Service bytesToBinary;

	public EntityImpl() throws Exception
	{
		bytesToBinary = Outside.service(this,"gus.tostring.bytetobinary");
	}

	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return null;
		if(obj instanceof Integer) return Integer.toBinaryString(toInt(obj));
		if(obj instanceof byte[]) return bytesToBinary.t(obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	private int toInt(Object obj)
	{return Integer.parseInt(""+obj);}
}
