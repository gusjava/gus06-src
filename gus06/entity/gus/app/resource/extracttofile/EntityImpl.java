package gus06.entity.gus.app.resource.extracttofile;

import gus06.framework.*;
import java.io.InputStream;
import java.io.File;
import java.io.FileOutputStream;

public class EntityImpl implements Entity, V {

	public String creationDate() {return "20150608";}



	private Service inside;
	private Service transfer;
	
	public EntityImpl() throws Exception
	{
		inside = Outside.service(this,"inside");
		transfer = Outside.service(this,"gus.io.transfer");
	}
	
	
	
	public void v(String key, Object obj) throws Exception
	{
		File file = (File) obj;
		
		InputStream is = (InputStream) inside.r("stream."+key);
		if(is==null) throw new Exception("No InputStream found for resource at: "+key);
		
		FileOutputStream fos = new FileOutputStream(file);
		transfer.p(new Object[]{is,fos});
	}
}
