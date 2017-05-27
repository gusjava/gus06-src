package gus06.entity.gus.sys.expression1.apply.op._tolines;

import gus06.framework.*;
import java.io.File;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151109";}


	private Service read;
	private Service split;
	
	public EntityImpl() throws Exception
	{
		read = Outside.service(this,"gus.file.read.string.list.autodetect");
		split = Outside.service(this,"gus.string.split.lines1.list");
	}

	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return null;
		if(obj instanceof String) return split.t(obj);
		if(obj instanceof File) return read.t(obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
}
