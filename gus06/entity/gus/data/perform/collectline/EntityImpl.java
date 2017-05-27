package gus06.entity.gus.data.perform.collectline;

import gus06.framework.*;
import java.io.File;

public class EntityImpl implements Entity, P, T {

	public String creationDate() {return "20170202";}
	
	
	private Service performFile;
	private Service performString;
	
	
	public EntityImpl() throws Exception
	{
		performFile = Outside.service(this,"gus.file.string.perform.lines.apply.t");
		performString = Outside.service(this,"gus.data.string.collectline");
	}
	
	public void p(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		Object input = o[0];
		
		if(input instanceof File)	{performFile.p(obj);return;}
		if(input instanceof StringBuffer){performString.p(obj);return;}
		
		throw new Exception("Invalid data type: "+input.getClass().getName());
	}

	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		Object input = o[0];
		
		if(input instanceof String) return performString.t(obj);
		
		throw new Exception("Invalid data type: "+input.getClass().getName());
	}
}
