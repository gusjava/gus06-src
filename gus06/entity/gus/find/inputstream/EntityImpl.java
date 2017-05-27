package gus06.entity.gus.find.inputstream;

import gus06.framework.*;
import java.io.InputStream;
import java.net.Socket;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;


public class EntityImpl implements Entity, T {

	public String creationDate() {return "20140928";}


	private Service convertProperties;
	private Service convertString;
	
	
	public EntityImpl() throws Exception
	{
		convertProperties = Outside.service(this,"gus.convert.propertiestoinputstream");
		convertString = Outside.service(this,"gus.convert.stringtoinputstream");
	}


	
	public Object t(Object obj) throws Exception
	{
		if(obj==null) return null;
		if(obj instanceof InputStream) return obj;
		
		if(obj instanceof Socket) return ((Socket) obj).getInputStream();
		if(obj instanceof File) return new FileInputStream((File) obj);
		if(obj instanceof byte[]) return new ByteArrayInputStream((byte[]) obj);
		if(obj instanceof Properties) return convertProperties.t(obj);
		if(obj instanceof String) return convertString.t(obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
}
