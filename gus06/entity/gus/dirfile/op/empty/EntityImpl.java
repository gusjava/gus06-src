package gus06.entity.gus.dirfile.op.empty;

import gus06.framework.*;
import java.io.File;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20150606";}


	private Service emptyDir;
	private Service emptyFile;


	public EntityImpl() throws Exception
	{
		emptyDir = Outside.service(this,"gus.dir.op.empty");
		emptyFile = Outside.service(this,"gus.file.op.empty");
	}
	
	
	public void p(Object obj) throws Exception
	{
		File f = (File) obj;
		
		if(f.isDirectory()) emptyDir.p(f);
		else if(f.isFile()) emptyFile.p(f);
	}
}
