package gus06.entity.gus.find.url;

import gus06.framework.*;
import java.net.URI;
import java.net.URL;
import java.io.File;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151126";}
	
	
	public Object t(Object obj) throws Exception
	{
		if(obj==null) return null;
		if(obj instanceof URL) return obj;
		if(obj instanceof URI) return ((URI) obj).toURL();
		if(obj instanceof File) return ((File) obj).toURI().toURL();
		if(obj instanceof String) return new URL((String) obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
}
