package gus06.entity.gus.sys.expression1.apply.op._is_tagname;

import gus06.framework.*;
import java.util.Map;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160729";}


	private Service check;
	
	public EntityImpl() throws Exception
	{
		check = Outside.service(this,"gus.sys.script1.tool.names.tagarray");
	}

	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return Boolean.FALSE;
		if(obj instanceof String) return new Boolean(check.f(obj));
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
}
