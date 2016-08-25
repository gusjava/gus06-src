package gus06.entity.gus.sys.expression1.apply.op._co_japanese;

import gus06.framework.*;
import java.io.File;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160817";}

	private Service readText;
	private Service check;
	
	public EntityImpl() throws Exception
	{
		readText = Outside.service(this,"gus.file.read.string.generic");
		check = Outside.service(this,"gus.filter.string.haschar.japanese");
	}

	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return null;
		if(obj instanceof String) return new Boolean(matches((String) obj));
		if(obj instanceof File) return new Boolean(matches((String) readText.t(obj)));
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	private boolean matches(String s) throws Exception
	{
		return check.f(s);
	}
}
