package gus06.entity.gus.java.fromclass.javasrc.resource;

import gus06.framework.*;
import java.io.InputStream;


public class EntityImpl implements Entity, T {

	public String creationDate() {return "20140819";}


	private Service inToString;

	public EntityImpl() throws Exception
	{inToString = Outside.service(this,"gus.io.transfer.tostring");}
	
	
	public Object t(Object obj) throws Exception
	{
		Class c = (Class) obj;
		String name = "/"+c.getName().replace(".","/")+".java";
		InputStream is = c.getResourceAsStream(name);
		
		if(is==null) return null;
		return inToString.t(is);
	}
}
