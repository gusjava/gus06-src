package gus06.entity.gus.sys.expression1.apply.op._charset;

import gus06.framework.*;
import java.io.File;

public class EntityImpl implements Entity, T, R {

	public String creationDate() {return "20151127";}


	private Service findCharset;


	public EntityImpl() throws Exception
	{
		findCharset = Outside.service(this,"gus.file.string.info.charset");
	}

	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return null;
		if(obj instanceof File) return findCharset.t(obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	public Object r(String key) throws Exception
	{
		if(key.equals("types")) return new Class[]{File.class};
		if(key.equals("keys")) return new String[]{"types"};
		throw new Exception("Unknown key: "+key);
	}
}
