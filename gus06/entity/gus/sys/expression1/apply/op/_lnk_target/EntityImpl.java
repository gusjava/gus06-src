package gus06.entity.gus.sys.expression1.apply.op._lnk_target;

import gus06.framework.*;
import java.io.File;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20170405";}


	private Service find;
	
	public EntityImpl() throws Exception
	{
		find = Outside.service(this,"gus.file.lnk.extract.path");
	}

	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return null;
		
		if(obj instanceof File) return find.t(obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
}