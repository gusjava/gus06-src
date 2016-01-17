package gus06.entity.gus.sys.expression1.apply.op._clipboard;

import gus06.framework.*;
import java.util.Map;
import java.io.File;
import java.util.Collection;
import java.awt.Image;
import java.util.List;

public class EntityImpl implements Entity, T, R {

	public String creationDate() {return "20151129";}


	private Service perform;
	
	
	public EntityImpl() throws Exception
	{
		perform = Outside.service(this,"gus.clipboard.access");
	}

	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		return perform.g();
	}
	
	public Object r(String key) throws Exception
	{
		if(key.equals("types")) return new Class[]{Object.class};
		if(key.equals("keys")) return new String[]{"types"};
		throw new Exception("Unknown key: "+key);
	}
}
