package gus06.entity.gus.dirfile.perform.removeall;

import gus06.framework.*;
import java.io.File;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20160412";}


	private Service handleFile;
	private Service handleDir;


	public EntityImpl() throws Exception
	{
		handleFile = Outside.service(this,"gus.file.perform.removeall");
		handleDir = Outside.service(this,"gus.dir.perform.removeall");
	}
	
	
	public void p(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		File f = (File) o[0];
		
		if(f.isFile()) handleFile.p(obj);
		else handleDir.p(obj);
	}
}
