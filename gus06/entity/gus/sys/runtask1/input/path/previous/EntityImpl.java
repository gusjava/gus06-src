package gus06.entity.gus.sys.runtask1.input.path.previous;

import gus06.framework.*;
import java.io.File;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20151017";}


	private Service runtaskFile;
	private Service runtaskDir;


	public EntityImpl() throws Exception
	{
		runtaskFile = Outside.service(this,"gus.sys.runtask1.input.file.previous");
		runtaskDir = Outside.service(this,"gus.sys.runtask1.input.dir.previous");
	}
	
	
	public void p(Object obj) throws Exception
	{
		File path = (File) obj;
		if(path==null || !path.exists()) return;
		
		if(path.isDirectory()) runtaskDir.p(path);
		else runtaskFile.p(path);
	}
}
