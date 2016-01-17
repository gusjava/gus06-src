package gus06.entity.gus.crypto.pbe1.file.prop.decrypt;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Properties;
import gus06.framework.*;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20150625";}

	
	private Service decrypt;
	private Service read;

	public EntityImpl() throws Exception
	{
		decrypt = Outside.service(this,"gus.crypto.pbe1.stringcol.decrypt");
		read = Outside.service(this,"gus.file.read.properties");
	}



	public void p(Object obj) throws Exception
	{
		File file = (File) obj;
		Properties p = (Properties) read.t(file);
		
		p = (Properties) decrypt.t(p);
		
		FileOutputStream fos = new FileOutputStream(file);
		p.store(fos,"");
		fos.close();
	}
}
