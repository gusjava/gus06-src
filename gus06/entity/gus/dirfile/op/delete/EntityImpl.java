package gus06.entity.gus.dirfile.op.delete;

import gus06.framework.*;
import java.io.File;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20150606";}


	private Service deleteDir;
	private Service deleteFile;


	public EntityImpl() throws Exception
	{
		deleteDir = Outside.service(this,"gus.dir.op.delete");
		deleteFile = Outside.service(this,"gus.file.op.delete");
	}
	
	
	public void p(Object obj) throws Exception
	{
		File f = (File) obj;
		
		if(f.isDirectory()) deleteDir.p(f);
		else deleteFile.p(f);
	}
}
