package gus06.entity.gus.java.fromclass.classurl;

import gus06.framework.*;
import java.net.URL;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20140804";}

	private Service asResource;
	
	public EntityImpl() throws Exception
	{
		asResource = Outside.service(this,"gus.java.fromclass.classurl.resource");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		URL url1 = (URL) asResource.t(obj);
		if(url1!=null) return url1;
		
		return null;
	}
}
