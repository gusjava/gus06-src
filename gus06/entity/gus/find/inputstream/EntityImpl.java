package gus06.entity.gus.find.inputstream;

import gus06.framework.*;
import java.io.InputStream;
import java.net.Socket;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;


public class EntityImpl implements Entity, T {

	public String creationDate() {return "20140928";}

	
	public Object t(Object obj) throws Exception
	{
		if(obj==null) return null;
		if(obj instanceof InputStream) return obj;
		
		if(obj instanceof Socket) return ((Socket) obj).getInputStream();
		if(obj instanceof File) return new FileInputStream((File) obj);
		if(obj instanceof byte[]) return new ByteArrayInputStream((byte[]) obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
}
