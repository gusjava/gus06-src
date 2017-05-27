package gus06.entity.gus.sys.expression1.apply.op._exec_tostring;

import gus06.framework.*;
import java.io.File;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20170410";}


	private Service performExec;
	
	
	public EntityImpl() throws Exception
	{
		performExec = Outside.service(this,"gus.data.perform.exec.tostring");
	}

	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return null;
		
		if(obj instanceof File) return performExec.t(obj);
		if(obj instanceof String) return performExec.t(obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
}
