package gus06.entity.gus.find.file;

import gus06.framework.*;
import java.io.File;
import java.nio.file.Path;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20140917";}
	
	
	public Object t(Object obj) throws Exception
	{
		if(obj==null) return null;
		if(obj instanceof File) return obj;
		if(obj instanceof String) return new File((String) obj);
		if(obj instanceof Path) return ((Path) obj).toFile();
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
}
