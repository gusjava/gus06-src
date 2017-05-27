package gus06.entity.gus.sys.expression1.apply.op._iterate_lines;

import gus06.framework.*;
import java.io.File;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160913";}


	private Service perform;
	
	public EntityImpl() throws Exception
	{perform = Outside.service(this,"gus.file.string.reader.providelines.autodetect");}

	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return null;
		if(obj instanceof File) return perform.t(obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
}
