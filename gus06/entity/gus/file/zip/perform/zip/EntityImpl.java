package gus06.entity.gus.file.zip.perform.zip;

import gus06.framework.*;
import java.io.File;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20160817";}


	private Service runZip;
	
	public EntityImpl() throws Exception
	{
		runZip = Outside.service(this,"gus.file.zip.run.zip");
	}


	
	public void p(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		Object input = o[0];
		File zipFile = (File) o[1];
		
		runZip.p(new Object[]{input,zipFile,null,null});
	}
}