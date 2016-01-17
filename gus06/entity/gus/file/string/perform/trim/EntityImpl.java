package gus06.entity.gus.file.string.perform.trim;

import gus06.framework.*;
import java.io.File;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20150817";}


	private Service read;
	private Service write;


	public EntityImpl() throws Exception
	{
		read = Outside.service(this,"gus.file.read.string");
		write = Outside.service(this,"gus.file.write.string");
	}
	
	
	public void p(Object obj) throws Exception
	{
		File f = (File) obj;
		String s = (String) read.t(f);
		if(s==null) return;
		
		write.p(new Object[]{f,s.trim()});
	}
}
